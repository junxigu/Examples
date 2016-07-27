define(['backbone'], {
  
  componentDidMount : function() {
    this.view = new (Backbone.View.extend(_.defaults(this, {
      el: this.getDOMNode(),
    })))();
  },

});
