angular.module("BandaApp", [])
        .value('urlBase', 'http://localhost:9080/bandasWeb/rest/')
        .controller("BandaController", function ($http, urlBase) {
            var self = this;

            self.bandas = [];
            self.bandas = undefined;

            self.novo = function () {
                self.banda = {};
            };

            self.salvar = function () {
                var metodo = 'POST';
                if (self.banda.codigo) {
                    metodo = 'PUT';
                }

                $http({
                    method: metodo,
                    url: urlBase + 'bandas/',
                    data: self.banda
                }).then(function successCallback(response) {
                    self.atualizarTabela();
                }, function errorCallback(response) {
                	console.log(response);
                    self.ocorreuErro();
                });
            };

            self.alterar = function (banda) {
                self.banda = banda;
            };

            self.deletar = function (banda) {
                self.banda = banda;

                $http({
                    method: 'DELETE',
                    url: urlBase + 'bandas/' + self.banda.codigo + '/'
                }).then(function successCallback(response) {
                    self.atualizarTabela();
                }, function errorCallback(response) {
                    self.ocorreuErro();
                });
            };

            self.ocorreuErro = function () {
                alert("Ocorreu um erro inesperado!");
            };

            self.atualizarTabela = function () {
                $http({
                    method: 'GET',
                    url: urlBase + 'bandas/'
                }).then(function successCallback(response) {
                    self.pessoas = response.data;
                    self.pessoa = undefined;
                }, function errorCallback(response) {
                    self.ocorreuErro();
                });
            };

            self.activate = function () {
                self.atualizarTabela();
            };
            
            self.activate();
        });