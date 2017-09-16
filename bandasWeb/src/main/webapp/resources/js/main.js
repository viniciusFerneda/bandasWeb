angular.module('BandaApp', ['minhasDiretivas','ngAnimate', 'ngRoute', 'ngResource', 
	'bandaServicos', 'cantaServicos', 'estiloServicos', 'gravadoraServicos', 'musicaServicos', 
	'paisServicos'])
	.config(function($routeProvider, $locationProvider) {

		$locationProvider.html5Mode(true);

		$routeProvider.when('/', {
			templateUrl: 'resources/html/principal.html'
		});

		//Cadastro de Banda

		$routeProvider.when('/bandas', {
			templateUrl: 'resources/html/banda/bandas.html',
			controller: 'BandasController'
		});

		$routeProvider.when('/bandas/new', {
			templateUrl: 'resources/html/banda/banda.html',
			controller: 'BandaController'
		});

		$routeProvider.when('/bandas/edit/:bandaId', {
			templateUrl: 'resources/html/banda/banda.html',
			controller: 'BandaController'
		});

		//Cadastro de Canta

		$routeProvider.when('/cantas', {
			templateUrl: 'resources/html/canta/cantas.html',
			controller: 'CantasController'
		});

		$routeProvider.when('/cantas/new', {
			templateUrl: 'resources/html/canta/canta.html',
			controller: 'CantaController'
		});

		$routeProvider.when('/cantas/edit/:cantaId', {
			templateUrl: 'resources/html/canta/canta.html',
			controller: 'CantaController'
		});

		//Cadastro de Estilo

		$routeProvider.when('/estilos', {
			templateUrl: 'resources/html/estilo/estilos.html',
			controller: 'EstilosController'
		});

		$routeProvider.when('/estilos/new', {
			templateUrl: 'resources/html/estilo/estilo.html',
			controller: 'EstiloController'
		});

		$routeProvider.when('/estilos/edit/:estiloId', {
			templateUrl: 'resources/html/estilo/estilo.html',
			controller: 'EstiloController'
		});

		//Cadastro de Gravadora

		$routeProvider.when('/gravadoras', {
			templateUrl: 'resources/html/gravadora/estilos.html',
			controller: 'GravadorasController'
		});

		$routeProvider.when('/gravadoras/new', {
			templateUrl: 'resources/html/gravadora/gravadora.html',
			controller: 'GravadoraController'
		});

		$routeProvider.when('/gravadoras/edit/:gravadoraId', {
			templateUrl: 'resources/html/gravadora/gravadora.html',
			controller: 'GravadoraController'
		});

		//Cadastro de Musica

		$routeProvider.when('/musicas', {
			templateUrl: 'resources/html/musica/musicas.html',
			controller: 'MusicasController'
		});

		$routeProvider.when('/musicas/new', {
			templateUrl: 'resources/html/musica/musica.html',
			controller: 'MusicaController'
		});

		$routeProvider.when('/musicas/edit/:musicaId', {
			templateUrl: 'resources/html/musica/musica.html',
			controller: 'MusicaController'
		});

		//Cadastro de Pais

		$routeProvider.when('/paises', {
			templateUrl: 'resources/html/pais/paises.html',
			controller: 'PaisesController'
		});

		$routeProvider.when('/paises/new', {
			templateUrl: 'resources/html/pais/pais.html',
			controller: 'PaisController'
		});

		$routeProvider.when('/paises/edit/:paisId', {
			templateUrl: 'resources/html/pais/pais.html',
			controller: 'PaisController'
		});

		$routeProvider.otherwise({redirectTo: '/'});

	});