angular.module('minhasDiretivas', [])
	.directive('meuPainel', function() {

		var ddo = {};

		ddo.restrict = "AE";
        ddo.transclude = true;


		ddo.scope = {
            titulo: '@'
        };

        ddo.templateUrl = 'js/directives/meu-painel.html';

		return ddo;
	})
    .directive('minhaBanda', function() {

        var ddo = {};

        ddo.restrict = "AE";

        ddo.scope = {
            nome: '@',
            dtCriacao: '@',
            pais: '@'
        };

        ddo.template = 'js/directives/minha-banda.html';
        
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