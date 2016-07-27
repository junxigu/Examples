define([ 'backbone', 'model/ServiceMerchantToken', ], function(Backbone,
    ServiceMerchantToken) {

  return Backbone.Collection.extend({

    url : "rest/merchantServiceTokens",

    model : ServiceMerchantToken,

  });

});