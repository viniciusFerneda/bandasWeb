angular.module('BandaApp', ['minhasDiretivas','ngAnimate', 'ngRoute', 'ngResource', 
	'bandaServicos', 'cantaServicos', 'estiloServicos', 'gravadoraServicos', 'musicaServicos', 
	'paisServicos'])
	.config(function($routeProvider, $locationProvider) {

		$locationProvider.html5Mode(true);

		$routeProvider.when('/bandas', {
			templateUrl: 'resources/html/principal.html'
		});

		//Cadastro de Banda

		$routeProvider.when('/bandas/bandas', {
			templateUrl: 'resources/html/banda/bandas.html',
			controller: 'BandasController'
		});

		$routeProvider.when('/bandas/bandas/new', {
			templateUrl: 'resources/html/banda/banda.html',
			controller: 'BandaController'
		});

		$routeProvider.when('/bandas/bandas/edit/:bandaId', {
			templateUrl: 'resources/html/banda/banda.html',
			controller: 'BandaController'
		});

		//Cadastro de Canta

		$routeProvider.when('/bandas/cantas', {
			templateUrl: 'resources/html/canta/cantas.html',
			controller: 'CantasController'
		});

		$routeProvider.when('/bandas/cantas/new', {
			templateUrl: 'resources/html/canta/canta.html',
			controller: 'CantaController'
		});

		$routeProvider.when('/bandas/cantas/edit/:cantaId', {
			templateUrl: 'resources/html/canta/canta.html',
			controller: 'CantaController'
		});

		//Cadastro de Estilo

		$routeProvider.when('/bandas/estilos', {
			templateUrl: 'resources/html/estilo/estilos.html',
			controller: 'EstilosController'
		});

		$routeProvider.when('/bandas/estilos/new', {
			templateUrl: 'resources/html/estilo/estilo.html',
			controller: 'EstiloController'
		});

		$routeProvider.when('/bandas/estilos/edit/:estiloId', {
			templateUrl: 'resources/html/estilo/estilo.html',
			controller: 'EstiloController'
		});

		//Cadastro de Gravadora

		$routeProvider.when('/bandas/gravadoras', {
			templateUrl: 'resources/html/gravadora/estilos.html',
			controller: 'GravadorasController'
		});

		$routeProvider.when('/bandas/gravadoras/new', {
			templateUrl: 'resources/html/gravadora/gravadora.html',
			controller: 'GravadoraController'
		});

		$routeProvider.when('/bandas/gravadoras/edit/:gravadoraId', {
			templateUrl: 'resources/html/gravadora/gravadora.html',
			controller: 'GravadoraController'
		});

		//Cadastro de Musica

		$routeProvider.when('/bandas/musicas', {
			templateUrl: 'resources/html/musica/musicas.html',
			controller: 'MusicasController'
		});

		$routeProvider.when('/bandas/musicas/new', {
			templateUrl: 'resources/html/musica/musica.html',
			controller: 'MusicaController'
		});

		$routeProvider.when('/bandas/musicas/edit/:musicaId', {
			templateUrl: 'resources/html/musica/musica.html',
			controller: 'MusicaController'
		});

		//Cadastro de Pais

		$routeProvider.when('/bandas/paises', {
			templateUrl: 'resources/html/pais/paises.html',
			controller: 'PaisesController'
		});

		$routeProvider.when('/bandas/paises/new', {
			templateUrl: 'resources/html/pais/pais.html',
			controller: 'PaisController'
		});

		$routeProvider.when('/bandas/paises/edit/:paisId', {
			templateUrl: 'resources/html/pais/pais.html',
			controller: 'PaisController'
		});

		$routeProvider.otherwise({redirectTo: '/bandas'});

	});