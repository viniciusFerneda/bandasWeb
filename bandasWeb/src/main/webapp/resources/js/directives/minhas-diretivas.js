angular.module('minhasDiretivas', [])
	.directive('meuPainel', function() {

		var ddo = {};

		ddo.restrict = "AE";
        ddo.transclude = true;

		ddo.scope = {
            titulo: '@'
        };

        ddo.templateUrl = 'bandasWeb/resources/js/directives/meu-painel.html';

		return ddo;
	})
    .directive('minhaBanda', function() {

        var ddo = {};

        ddo.restrict = "AE";

        ddo.scope = {
        	dtcriacao: '@',
            pais: '@'
        };

        ddo.templateUrl = 'bandasWeb/resources/js/directives/minha-banda.html';
        
        return ddo;
    })
    .directive('meuEstilo', function() {

        var ddo = {};

        ddo.restrict = "AE";

        ddo.scope = {
        	codigo: '@',
            nome: '@'
        };

        ddo.templateUrl = 'bandasWeb/resources/js/directives/meu-estilo.html';
        
        return ddo;
    })
    .directive('meuPais', function() {

        var ddo = {};

        ddo.restrict = "AE";

        ddo.scope = {
        	codigo: '@',
            nome: '@'
        };

        ddo.templateUrl = 'bandasWeb/resources/js/directives/meu-pais.html';
        
        return ddo;
    })
    .directive('minhaCanta', function() {

        var ddo = {};

        ddo.restrict = "AE";

        ddo.scope = {
        	anogravacao: '@',
        	banda: '@',
        	musica: '@',
        	gravadora: '@',
        	estilo: '@'
        };

        ddo.templateUrl = 'bandasWeb/resources/js/directives/minha-canta.html';
        
        return ddo;
    })
    .directive('minhaGravadora', function() {

        var ddo = {};

        ddo.restrict = "AE";

        ddo.scope = {
        	pais: '@'
        };

        ddo.templateUrl = 'bandasWeb/resources/js/directives/minha-gravadora.html';
        
        return ddo;
    })
    .directive('minhaMusica', function() {

        var ddo = {};

        ddo.restrict = "AE";

        ddo.scope = {
        	duracao: '@'
        };

        ddo.templateUrl = 'bandasWeb/resources/js/directives/minha-musica.html';
        
        return ddo;
    })
    .directive('meuBotaoPerigo', function() {
        var ddo = {};
        ddo.restrict = "E";
        ddo.scope = {
            nome: '@',
            acao : '&'
        }
        ddo.template = '<button class="btn btn-danger btn-block" ng-click="acao()">{{nome}}</button>';

        return ddo;
    })
    .directive('meuFocus', function() {
        var ddo = {};
        ddo.restrict = "A";
       
        ddo.link = function(scope, element) {
             scope.$on('bandaCadastrada', function() {
                 element[0].focus();
             });
        };

        return ddo;
    })
    .directive('meusNomes', function() {
        var ddo = {};
        ddo.restrict = 'E';
        ddo.template = '<ul><li ng-repeat="nome in nomes">{{nome}}</li></ul>';
        ddo.controller = function($scope, recursoBanda) {
            recursoBanda.query(function(bandas) {
                $scope.nomes = bandas.map(function(banda) {
                    return banda.nome;
                });    
            });
        };
        return ddo;
    });