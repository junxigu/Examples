define([ 'backbone', 'model/ServiceMerchantToken', 'sub/TokenTable',
    'collection/ServiceMerchantTokens', 'sub/InsertTokenTable',
    'util/AjaxUtils', 'collection/CountryCodes', 'collection/ServiceMerchants',
    'util/CollectionUtils', 'root/conf' ], function(Backbone,
    ServiceMerchantToken, TokenTable, ServiceMerchantTokens, InsertTokenTable,
    AjaxUtils, CountryCodes, ServiceMerchants, CollectionUtils, conf) {

  return Backbone.View.extend({

    el : 'body',

    initialize : function() {
      this.merchantServices = new ServiceMerchants();
      this.countryCodes = new CountryCodes();
      this.tokens = new ServiceMerchantTokens();
      return this;
    },

    render : function() {
      this.merchantServices.fetch({
        success : function() {
          this.countryCodes.fetch({
            success : function() {
              this.tokens.fetch({
                success : function() {
                  this.initTables();
                }.bind(this),
              });
            }.bind(this),
          });
        }.bind(this),
      });
      return this;
    },

    initTables : function() {
      var table = new TokenTable(this.tokens).render();

      var insertTable = new InsertTokenTable(this.tokens)
          .render(CollectionUtils.getOptValText(this.merchantServices, 'id',
              'address1'), CollectionUtils.getOptValText(this.countryCodes,
              'id', 'countryCode'));

      this.listenTo(insertTable, 'insertToken', table.insertToken.bind(table));
    },
  });

});