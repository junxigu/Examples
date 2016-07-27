define([ 'backbone', 'model/ServiceMerchantToken', 'sub/TokenTable',
    'collection/ServiceMerchantTokens', 'sub/InsertTokenTable', 
    'util/AjaxUtils', 'collection/CountryCodes', 'collection/ServiceMerchants',
    'util/CollectionUtils'], function(
    Backbone, ServiceMerchantToken, TokenTable, ServiceMerchantTokens,
    InsertTokenTable, AjaxUtils, CountryCodes, ServiceMerchants,
    CollectionUtils) {

  return Backbone.View.extend({

    el : 'body',

    events : {
    },

    initTables: function(merchants, countryCodes){
      ServiceMerchantTokens.getMerchantTokens(function(tokensData){
        var tokens = new ServiceMerchantTokens(tokensData);
        var table = new TokenTable(tokens).render();
        var insertTable = new InsertTokenTable(tokens).render(
            CollectionUtils.getOptValText(merchants, 'id', 'address1'),
            CollectionUtils.getOptValText(countryCodes, 'id', 'countryCode'));
        this.listenTo(insertTable, 'insertToken', table.insertToken.bind(table));
      }.bind(this));
      return this;
    },
    
    initialize : function() {
      ServiceMerchants.getServiceMerchants(function(merchants){
        CountryCodes.getCountryCodes(function(countryCodes){
          this.initTables(merchants, countryCodes);
        }.bind(this));
      }.bind(this));
      return this;
    },

    render : function() {
      return this;
    },

  });

});