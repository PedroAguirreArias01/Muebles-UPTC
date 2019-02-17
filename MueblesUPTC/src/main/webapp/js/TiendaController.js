'use strict';

module.controller('TiendaCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        //listar
        $scope.lista = null;
        $scope.listaDetallesF = null;
        $scope.listaFacturas = null;
        $scope.listaClientes = null;
        $scope.listaProductos = null;
        $scope.datosFormularioFactura = {listaDetallesF: []};
        $scope.datosDetalles = {};
        $scope.datosCliente = {};
        let valorTotal = 0;

        $scope.agregarCarrito = function (dato) {
            $('#modalCantidad').modal('show');
            $scope.datosDetalles = dato;
        };

        $scope.guardarCantidad = function () {
            valorTotal = $scope.datosDetalles.cantidadDetalle * $scope.datosDetalles.valor;
            console.log(valorTotal);

            $('#modalCantidad').modal('hide');
            console.log($scope.datosDetalles);
        };

        $scope.validarCliente = function () {
            $('#modalRegistrarCliente').modal('show');
        };

        $scope.finalizarCompra = function () {
            for (var i = 0; i < $scope.listaClientes.length; i++) {
                if ($scope.listaClientes[i].cedula === $scope.datosCliente.cedula) {
                    console.log("Entraaa " + $scope.listaClientes[i].nombre);
                    $scope.datosFormularioFactura = $scope.listaClientes[i];
                }
            }
            console.log("Factura: " + $scope.datosFormularioFactura.idClienteFactura.cedula);
            $('#modalCantidad').modal('hide');
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
            console.log($scope.datosFormulario);
            $http.post("./webresources/ServicioFactura", $scope.datosFormularioFactura)
                    .then(function (response) {
                        $scope.getConsulta();
                    });
            $scope.panelEditar = false;
        };

        $scope.crearDetalle = function () {
            console.log($scope.datosFormulario);
            $http.post("./webresources/ServicioDetalleFactura", $scope.datosDetalles)
                    .then(function (response) {
                        $scope.getConsulta();
                    });
            $scope.panelEditar = false;
        };

        $scope.getProductos();
        $scope.getDetalles();
        $scope.getFactura();
        $scope.getCliente();
    }]);
