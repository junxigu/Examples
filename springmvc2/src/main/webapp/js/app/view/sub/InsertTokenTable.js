define([ 'backbone', 'model/ServiceMerchantToken', 'util/ViewUtils', ],
    function(Backbone, ServiceMerchantToken, ViewUtils) {

      return Backbone.View.extend({

        el : '#insertTokenTable',

        events : {
          'click .insert' : 'insertToken',
        },

        initialize : function(tokens) {
          this.tokens = tokens;
          return this;
        },

        render : function(merchants, countryCodes) {
          ViewUtils.appendIdToSelect(merchants, this.$('.serviceMerchantId'))
              .appendIdToSelect(countryCodes, this.$('.countryCode'));
          return this;
        },

        createTokenByInfos : function() {
          var token = new ServiceMerchantToken();
          ViewUtils.collectInfoToToken(this.$('select, input'), token);
          return token;
        },

        insertToken : function() {
          this.createTokenByInfos().save({}, {
            success: function(model){
              this.trigger('insertToken', model);
            }.bind(this),
            error: function(model, xhr){
              $('html').html(xhr.responseText);
            },
          });
          return this;
        },
      });

    });