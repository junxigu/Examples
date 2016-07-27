define([ 'backbone', 'sub/ServiceMerchantTable',
    'collection/ServiceMerchants', 'sub/InsertServiceMerchantTable',
    'util/AjaxUtils', 'util/CollectionUtils'], 
function(Backbone, ServiceMerchantTable, ServiceMerchants,
    InsertServiceMerchantTable, AjaxUtils,
    CollectionUtils) {

  return Backbone.View.extend({

    el : 'body',

    events : {
    },

    initTables: function(){
      ServiceMerchants.fetchServiceMerchants(function(tokensData){
    	var tokens = new ServiceMerchants(tokensData);
    	var table = new ServiceMerchantTable(tokens).render();
    	var insertTable = new InsertServiceMerchantTable(tokens).render();
    	this.listenTo(insertTable, 'insertToken', table.insertToken.bind(table));
      }.bind(this));
      return this;
    },

    render : function() {
      this.initTables();
      return this;
    },

  });

});