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

        $scope.getProductos = function () {
            $http.get("./webresources/ServicioProducto", {})
                    .then(function (response) {
                        $scope.lista = response.data;
                        for (var i = 0; i < $scope.lista.length; i++) {
                            //console.log($scope.lista[i]);
                        }
                    }, function () {
                        alert("VER CONSULTAS EN CONSOLA DE GLASSFISH");
                    });
        };

        $scope.getDetalles = function () {
            $http.get("./webresources/ServicioDetalleFactura", {})
                    .then(function (response) {
                        console.log("Aca");
                        $scope.listaDetallesF = response.data;
                        for (var i = 0; i < $scope.listaDetallesF.length; i++) {
                            console.log($scope.listaDetallesF[i]);
                        }
                    }, function () {
                        alert("ERROR EN OBTENER DETALLES");
                    });
        };
        
        $scope.getFactura = function () {
            $http.get("./webresources/ServicioFactura", {})
                    .then(function (response) {
                        console.log("Aca");
                        $scope.listaFacturas = response.data;
                        for (var i = 0; i < $scope.listaFacturas.length; i++) {
                            console.log($scope.listaFacturas[i]);
                        }
                    }, function () {
                        alert("ERROR EN OBTENER FACTURAS");
                    });
        };
        
        $scope.getCliente = function () {
            $http.get("./webresources/ServicioClienteFactura", {})
                    .then(function (response) {
                        console.log("Clientess... ");
                        $scope.listaClientes = response.data;
                        for (var i = 0; i < $scope.listaClientes.length; i++) {
                            console.log($scope.listaClientes[i]);
                        }
                    }, function () {
                        alert("ERROR EN OBTENER CLIENTES");
                    });
        };


        $scope.guardarFactura = function () {
            console.log($scope.datosFormulario);
            $http.post("./webresources/ServicioFactura", $scope.datosFormulario)
                    .then(function (response) {
                        $scope.getConsulta();
                    });
            $scope.panelEditar = false;
        };

        $scope.crearDetalle = function () {
            console.log($scope.datosFormulario);
            $http.post("./webresources/ServicioDetalleFactura", $scope.datosFormulario)
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
