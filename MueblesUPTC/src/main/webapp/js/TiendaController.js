'use strict';

module.controller('TiendaCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        //listar
        $scope.lista = null;
        //$scope.listaDetallesF = null;
        $scope.listaFacturas = null;
        $scope.listaClientes = null;
        $scope.listaProductos = null;
        $scope.datosFormularioFactura = {listaDetallesF: []};
        $scope.datosDetalles = {};
        $scope.datosCliente = {};

        $scope.agregarCarrito = function (dato) {
            $('#modalCantidad').modal('show');
            $scope.datosDetalles.idProducto = dato;
        };

        $scope.guardarCantidad = function () {
            $scope.datosDetalles.valorTotal = $scope.datosDetalles.idProducto.valor * $scope.datosDetalles.cantidadDetalle;
            $scope.datosFormularioFactura.listaDetallesF.push($scope.datosDetalles);
            
            //console.log('estos son los datos de destalles' + JSON.stringify($scope.datosDetalles));
            //$scope.datosDetalles.idFactura = $scope.datosFormularioFactura;
            $scope.crearDetalle();
            $('#modalCantidad').modal('hide');
        };

        $scope.validarCliente = function () {
            $('#modalRegistrarCliente').modal('show');
        };

        $scope.mostrarCrearCliente = function () {
            $('#modalRegistrarCliente').modal('hide');
            $('#modalCrearCliente').modal('show');
        };

        $scope.finalizarCompra = function () {
            console.log("Factura: " + JSON.stringify($scope.datosFormularioFactura));
            $scope.guardarFactura();
            alert('COMPRA FINALIZADA CON EXITO');
            $('#modalRegistrarCliente').modal('hide');
        };

        $scope.getProductos = function () {
            $http.get("./webresources/ServicioProducto", {})
                    .then(function (response) {
                        $scope.lista = response.data;
                    }, function () {
                        alert("VER CONSULTAS EN CONSOLA DE GLASSFISH");
                    });
        };

        $scope.getDetalles = function () {
            $http.get("./webresources/ServicioDetalleFactura", {})
                    .then(function (response) {
                        $scope.listaDetallesF = response.data;
                    }, function () {
                        alert("ERROR EN OBTENER DETALLES");
                    });
        };

        $scope.getFactura = function () {
            $http.get("./webresources/ServicioFactura", {})
                    .then(function (response) {
                        $scope.listaFacturas = response.data;
                    }, function () {
                        alert("ERROR EN OBTENER FACTURAS");
                    });
        };

        $scope.getCliente = function () {
            $http.get("./webresources/ServicioClienteFactura", {})
                    .then(function (response) {
                        $scope.listaClientes = response.data;
                    }, function () {
                        alert("ERROR EN OBTENER CLIENTES");
                    });
        };

        $scope.guardarFactura = function () {
            $http.post("./webresources/ServicioFactura", $scope.datosFormularioFactura)
                    .then(function (response) {
                        //$scope.getConsulta();
                    });
            $scope.panelEditar = false;
        };

        $scope.crearDetalle = function () {
            $http.post("./webresources/ServicioDetalleFactura", $scope.datosDetalles)
                    .then(function (response) {
                        $scope.getDetalles();
                    });

        };

        $scope.crearCliente = function () {
            console.log("Esto es cliente " + JSON.stringify($scope.datosCliente));
            $http.post("./webresources/ServicioClienteFactura", $scope.datosCliente)
                    .then(function (response) {
//                        $scope.getConsulta();
                    });
            $('#modalCrearCliente').modal('hide');
            $('#modalRegistrarCliente').modal('show');
        };

        $scope.getProductos();
        //$scope.getDetalles();
        $scope.getFactura();
        $scope.getCliente();
    }]);
