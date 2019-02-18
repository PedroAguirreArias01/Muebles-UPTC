'use strict';

// Declare app level module which depends on filters, and services
var app = angular.module('adminTienda', [
    'ngRoute',
    'ngMaterial',
    'ngMessages',
    'adminTienda.controllers'
]);
app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/', {templateUrl: 'partials/Tienda.html', controller: 'TiendaCtrl'});
        $routeProvider.otherwise({redirectTo: '/'});
    }]);

var module = angular.module("adminTienda.controllers", []);

