define([ 'backbone', 'sub/TdRowView' ], function(Backbone, TdRowView) {

  return Backbone.View.extend({
    el : '#tokenTable',

    thText : $('#table-head-col').html(),

    emptyColNum : 2,

    header : {
      'ID' : 'id',
      'MERCHANT' : 'serviceMerchantId',
      'COUNTRY CODE' : 'countryCode',
      'ALIAS' : 'alias',
      'PASSWORD' : 'password',
      'PARTNER ID' : 'partnerId',
      'SYSTEM ID' : 'systemId',
      'CERTIFICATE' : 'certificate',
      'DESCRIPTION' : 'description',
      'CREATION TIME' : 'creationTime',
      'UPDATE TIME' : 'updateTime',
    },

    initialize : function(tokens) {
      this.tokens = tokens;
      return this;
    },

    render : function() {
      this.$tbody = this.$('tbody');
      this.renderTitle().renderContent();
      return this;
    },

    renderTitle : function() {
      var $tr = this.$('thead tr');

      this.appendEmptyCols(this.emptyColNum, $tr);
      for (title in this.header) {
        this.appendTitleCol(title, $tr);
      }
      return this;
    },

    appendEmptyCols : function(num, $tr) {
      for (var i = 0; i < num; i++) {
        this.appendTitleCol('', $tr);
      }
    },

    appendTitleCol : function(title, $tr) {
      var template = _.template(this.thText);
      $tr.append(template({
        title : title
      }));
      return this;
    },

    renderContent : function() {
      this.tokens.each(this.appendTdView.bind(this));
      return this;
    },

    appendTdView: function(token){
      this.$tbody.append(new TdRowView(token).render().$el);
      return this;
    },
    
    insertToken: function(token) {
      this.appendTdView(token).tokens.add(token);
      return this;
    },
  });

});