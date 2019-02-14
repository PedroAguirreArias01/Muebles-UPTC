'use strict';

module.controller('TiendaCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        //listar
        $scope.lista = null;
        $scope.listaDetalles = null;
        $scope.listaProductos = null;
        $scope.datosFormularioFactura = {listaDetalles: []};
        $scope.datosFormularioDetalle = {};

        $scope.getConsulta = function () {
            $http.get("./webresources/ServicioProducto", {})
                    .then(function (response) {
                        $scope.lista = response.data;
                        for (var i = 0; i < $scope.lista.length; i++) {
                            console.log($scope.lista[i]);
                        }
                    }, function () {
                        alert("VER CONSULTAS EN CONSOLA DE GLASSFISH");
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
    }]);
