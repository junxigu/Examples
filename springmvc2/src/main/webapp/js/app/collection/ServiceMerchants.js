define([ 'backbone', 'model/ServiceMerchant', ], function(Backbone,
    ServiceMerchant) {

  var ServiceMerchants = Backbone.Collection.extend({

    url : "rest/merchantServices",
    
    model : ServiceMerchant,

  });

  return ServiceMerchants;
});