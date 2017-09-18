angular.module('BandaApp', ['minhasDiretivas','ngAnimate', 'ngRoute', 'ngResource', 
	'bandaServicos', 'cantaServicos', 'estiloServicos', 'gravadoraServicos', 'musicaServicos', 
	'paisServicos'])
	.config(function($routeProvider, $locationProvider) {

		$locationProvider.html5Mode(true);
		
		$routeProvider.when('/bandasWeb/home', {
			templateUrl: '/bandasWeb/resources/html/principal.html'
		});
		
		//Cadastro de Banda
		$routeProvider.when('/bandas', {
			templateUrl: '/bandasWeb/resources/html/banda/bandas.html',
			controller: 'BandasController'
		});

		$routeProvider.when('/bandas/new', {
			templateUrl: '/bandasWeb/resources/html/banda/banda.html',
			controller: 'BandaController'
		});

		$routeProvider.when('/bandas/edit/:bandaId', {
			templateUrl: '/bandasWeb/resources/html/banda/banda.html',
			controller: 'BandaController'
		});

		//Cadastro de Canta
		$routeProvider.when('/cantas', {
			templateUrl: '/bandasWeb/resources/html/canta/cantas.html',
			controller: 'CantasController'
		});

		$routeProvider.when('/cantas/new', {
			templateUrl: '/bandasWeb/resources/html/canta/canta.html',
			controller: 'CantaController'
		});

		$routeProvider.when('/cantas/edit/:cantaId', {
			templateUrl: '/bandasWeb/resources/html/canta/canta.html',
			controller: 'CantaController'
		});

		//Cadastro de Estilo
		$routeProvider.when('/estilos', {
			templateUrl: '/bandasWeb/resources/html/estilo/estilos.html',
			controller: 'EstilosController'
		});

		$routeProvider.when('/estilos/new', {
			templateUrl: '/bandasWeb/resources/html/estilo/estilo.html',
			controller: 'EstiloController'
		});

		$routeProvider.when('/estilos/edit/:estiloId', {
			templateUrl: '/bandasWeb/resources/html/estilo/estilo.html',
			controller: 'EstiloController'
		});

		//Cadastro de Gravadora
		$routeProvider.when('/gravadoras', {
			templateUrl: '/bandasWeb/resources/html/gravadora/estilos.html',
			controller: 'GravadorasController'
		});

		$routeProvider.when('/gravadoras/new', {
			templateUrl: '/bandasWeb/resources/html/gravadora/gravadora.html',
			controller: 'GravadoraController'
		});

		$routeProvider.when('/gravadoras/edit/:gravadoraId', {
			templateUrl: '/bandasWeb/resources/html/gravadora/gravadora.html',
			controller: 'GravadoraController'
		});

		//Cadastro de Musica
		$routeProvider.when('/musicas', {
			templateUrl: '/bandasWeb/resources/html/musica/musicas.html',
			controller: 'MusicasController'
		});

		$routeProvider.when('/musicas/new', {
			templateUrl: '/bandasWeb/resources/html/musica/musica.html',
			controller: 'MusicaController'
		});

		$routeProvider.when('/musicas/edit/:musicaId', {
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