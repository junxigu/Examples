define([ 'backbone', 'model/ServiceMerchantToken', 'util/ViewUtils', ], function(Backbone,
    ServiceMerchantToken, ViewUtils) {

  return Backbone.View.extend({
    el : '#insertTokenTable',

    events: {
      'click .insert': 'insertToken',
    },
    
    initialize: function(tokens){
      this.tokens = tokens;
      return this;
    },
    
    render : function(merchants, countryCodes) {
      ViewUtils.appendIdToSelect(merchants,
          this.$('.serviceMerchantId')).appendIdToSelect(countryCodes,
          this.$('.countryCode'));
      return this;
    },

    createTokenByInfos: function(){
      var token = new ServiceMerchantToken();
      ViewUtils.collectInfoToToken(this.$('select, input'), token);
      return token;
    },
    
    insertToken : function() {
      var token = this.createTokenByInfos();
        token.insert(function(data){
          this.trigger('insertToken', new ServiceMerchantToken(data));
        }.bind(this));
      return this;
    },

    isDuplicatedCodes: function(token){
      return this.tokens.findWhere({
        serviceMerchantId: parseInt(token.get('merchantToken.serviceMerchantId')),
        countryCode: parseInt(token.get('merchantToken.countryCode')),
      }) == null;
    },
  });

});