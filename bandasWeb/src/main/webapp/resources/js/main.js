angular.module('BandaApp', ['minhasDiretivas','ngAnimate', 'ngRoute', 'ngResource', 'meusServicos'])
	.config(function($routeProvider, $locationProvider) {

		$locationProvider.html5Mode(true);

		$routeProvider.when('/bandas', {
			templateUrl: 'html/principal.html'
		});

		//Cadastro de Banda

		$routeProvider.when('/bandas/bandas', {
			templateUrl: 'html/banda/bandas.html',
			controller: 'BandasController'
		});

		$routeProvider.when('/bandas/bandas/new', {
			templateUrl: 'html/banda/banda.html',
			controller: 'BandaController'
		});

		$routeProvider.when('/bandas/bandas/edit/:bandaId', {
			templateUrl: 'html/banda/banda.html',
			controller: 'BandaController'
		});

		//Cadastro de Canta

		$routeProvider.when('/bandas/cantas', {
			templateUrl: 'html/canta/cantas.html',
			controller: 'CantasController'
		});

		$routeProvider.when('/bandas/cantas/new', {
			templateUrl: 'html/canta/canta.html',
			controller: 'CantaController'
		});

		$routeProvider.when('/bandas/cantas/edit/:cantaId', {
			templateUrl: 'html/canta/canta.html',
			controller: 'CantaController'
		});

		//Cadastro de Estilo

		$routeProvider.when('/bandas/estilos', {
			templateUrl: 'html/estilo/estilos.html',
			controller: 'EstilosController'
		});

		$routeProvider.when('/bandas/estilos/new', {
			templateUrl: 'html/estilo/estilo.html',
			controller: 'EstiloController'
		});

		$routeProvider.when('/bandas/estilos/edit/:estiloId', {
			templateUrl: 'html/estilo/estilo.html',
			controller: 'EstiloController'
		});

		//Cadastro de Gravadora

		$routeProvider.when('/bandas/gravadoras', {
			templateUrl: 'html/gravadora/estilos.html',
			controller: 'GravadorasController'
		});

		$routeProvider.when('/bandas/gravadoras/new', {
			templateUrl: 'html/gravadora/gravadora.html',
			controller: 'GravadoraController'
		});

		$routeProvider.when('/bandas/gravadoras/edit/:gravadoraId', {
			templateUrl: 'html/gravadora/gravadora.html',
			controller: 'GravadoraController'
		});

		//Cadastro de Musica

		$routeProvider.when('/bandas/musicas', {
			templateUrl: 'html/musica/musicas.html',
			controller: 'MusicasController'
		});

		$routeProvider.when('/bandas/musicas/new', {
			templateUrl: 'html/musica/musica.html',
			controller: 'MusicaController'
		});

		$routeProvider.when('/bandas/musicas/edit/:musicaId', {
			templateUrl: 'html/musica/musica.html',
			controller: 'MusicaController'
		});

		//Cadastro de Pais

		$routeProvider.when('/bandas/paises', {
			templateUrl: 'html/pais/paises.html',
			controller: 'PaisesController'
		});

		$routeProvider.when('/bandas/paises/new', {
			templateUrl: 'html/pais/pais.html',
			controller: 'PaisController'
		});

		$routeProvider.when('/bandas/paises/edit/:paisId', {
			templateUrl: 'html/pais/pais.html',
			controller: 'PaisController'
		});

		$routeProvider.otherwise({redirectTo: '/bandas'});

	});