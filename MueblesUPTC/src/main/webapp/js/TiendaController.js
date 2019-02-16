'use strict';

module.controller('TiendaCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        //listar
        $scope.lista = null;
        $scope.listaDetalles = null;
        $scope.listaProductos = null;
        $scope.datosFormularioFactura = {listaDetalles: []};
        $scope.datosDetalles = {};
        
        $scope.agregarCarrito = function (dato) {
            $('#modalCantidad').modal('show');
            $scope.datosDetalles = dato;
            for (var i = 0; i < $scope.lista.length; i++) {
                if (dato.idProducto === $scope.lista[i].idProducto) {
                    $scope.datosFormularioFactura.listaDetalles.push($scope.lista[i]);
                }
            }
        };
        
        $scope.guardarCantidad = function () {
           $('#modalCantidad').modal('hide');
           console.log($scope.datosDetalles);
        };

        $scope.getConsulta = function () {
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
                        $scope.listaDetalles = response.data;
                        for (var i = 0; i < $scope.lista.length; i++) {
                            console.log($scope.listaDetalles[i]);
                        }
                    }, function () {
                        alert("ERROR EN OBTENER DETALLES");
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
        
        $scope.getConsulta();
        $scope.getDetalles();
    }]);
