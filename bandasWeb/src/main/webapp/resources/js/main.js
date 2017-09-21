angular.module('BandaApp', ['minhasDiretivas','ngAnimate', 'ngRoute', 'ngResource', 
	'bandaServicos', 'cantaServicos', 'estiloServicos', 'gravadoraServicos', 'musicaServicos', 
	'paisServicos'])
	.config(function($routeProvider, $locationProvider) {

		$locationProvider.html5Mode(true);
		
		$routeProvider.when('/bandasWeb/home', {
			templateUrl: '/bandasWeb/resources/html/principal.html'
		});
		
		//Cadastro de Banda
		$routeProvider.when('/bandasWeb/bandas', {
			templateUrl: '/bandasWeb/resources/html/banda/bandas.html',
			controller: 'BandasController'
		});

		$routeProvider.when('/bandasWeb/bandas/new', {
			templateUrl: '/bandasWeb/resources/html/banda/banda.html',
			controller: 'BandaController'
		});

		$routeProvider.when('/bandasWeb/bandas/edit/:bandaId', {
			templateUrl: '/bandasWeb/resources/html/banda/banda.html',
			controller: 'BandaController'
		});

		//Cadastro de Canta
		$routeProvider.when('/bandasWeb/cantas', {
			templateUrl: '/bandasWeb/resources/html/canta/cantas.html',
			controller: 'CantasController'
		});

		$routeProvider.when('/bandasWeb/cantas/new', {
			templateUrl: '/bandasWeb/resources/html/canta/canta.html',
			controller: 'CantaController'
		});

		$routeProvider.when('/bandasWeb/cantas/edit/:cantaId', {
			templateUrl: '/bandasWeb/resources/html/canta/canta.html',
			controller: 'CantaController'
		});

		//Cadastro de Estilo
		$routeProvider.when('/bandasWeb/estilos', {
			templateUrl: '/bandasWeb/resources/html/estilo/estilos.html',
			controller: 'EstilosController'
		});

		$routeProvider.when('/bandasWeb/estilos/new', {
			templateUrl: '/bandasWeb/resources/html/estilo/estilo.html',
			controller: 'EstiloController'
		});

		$routeProvider.when('/bandasWeb/estilos/edit/:estiloId', {
			templateUrl: '/bandasWeb/resources/html/estilo/estilo.html',
			controller: 'EstiloController'
		});

		//Cadastro de Gravadora
		$routeProvider.when('/bandasWeb/gravadoras', {
			templateUrl: '/bandasWeb/resources/html/gravadora/estilos.html',
			controller: 'GravadorasController'
		});

		$routeProvider.when('/bandasWeb/gravadoras/new', {
			templateUrl: '/bandasWeb/resources/html/gravadora/gravadora.html',
			controller: 'GravadoraController'
		});

		$routeProvider.when('/bandasWeb/gravadoras/edit/:gravadoraId', {
			templateUrl: '/bandasWeb/resources/html/gravadora/gravadora.html',
			controller: 'GravadoraController'
		});

		//Cadastro de Musica
		$routeProvider.when('/bandasWeb/musicas', {
			templateUrl: '/bandasWeb/resources/html/musica/musicas.html',
			controller: 'MusicasController'
		});

		$routeProvider.when('/bandasWeb/musicas/new', {
			templateUrl: '/bandasWeb/resources/html/musica/musica.html',
			controller: 'MusicaController'
		});

		$routeProvider.when('/bandasWeb/musicas/edit/:musicaId', {
			templateUrl: '/bandasWeb/resources/html/musica/musica.html',
			controller: 'MusicaController'
		});

		//Cadastro de Pais
		$routeProvider.when('/bandasWeb/paises', {
			templateUrl: '/bandasWeb/resources/html/pais/paises.html',
			controller: 'PaisesController'
		});

		$routeProvider.when('/bandasWeb/paises/new', {
			templateUrl: '/bandasWeb/resources/html/pais/pais.html',
			controller: 'PaisController'
		});

		$routeProvider.when('/bandasWeb/paises/edit/:paisId', {
			templateUrl: '/bandasWeb/resources/html/pais/pais.html',
			controller: 'PaisController'
		});

		$routeProvider.otherwise({redirectTo: '/bandasWeb/home'});

	});