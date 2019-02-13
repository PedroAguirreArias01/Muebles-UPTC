'use strict';

module.controller('TiendaCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        //listar
        $scope.lista = null;
        
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

       
        $scope.getConsulta();
    }]);
