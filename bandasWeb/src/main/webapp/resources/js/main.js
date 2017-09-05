angular.module('BandaApp', ['minhasDiretivas','ngAnimate', 'ngRoute', 'ngResource', 'meusServicos'])
	.config(function($routeProvider, $locationProvider) {

		$locationProvider.html5Mode(true);

		$routeProvider.when('/bandas', {
			templateUrl: 'html/main.html',
			controller: 'BandasController'
		});

		$routeProvider.when('/bandas/new', {
			templateUrl: 'html/banda.html',
			controller: 'BandaController'
		});

		$routeProvider.when('/bandas/edit/:bandaId', {
			templateUrl: 'html/banda.html',
			controller: 'BandaController'
		});

		$routeProvider.otherwise({redirectTo: '/bandas'});

	});