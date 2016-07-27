/** @jsx React.DOM */
'use strict';
define([
  'react',
  'action/Actions',
], function(React, Actions) {

  var ReactPropTypes = React.PropTypes;
  var localize = Globalize.localize.bind(Globalize);

  var Header = React.createClass({

    propTypes: {
      title: ReactPropTypes.string.isRequired,
    },
    
    render : function() {
      var props = this.props;
      var backButton = props.backButton && props.backButtonHandler &&
        <a data-icon='back' data-role='button' data-theme='d'
          data-iconpos='notext' onTouchEnd={props.backButtonHandler}>Back</a>
      var homeButton = props.homeButton && props.homeButtonHandler &&
        <a data-icon='home' data-role='button' data-theme='d'
          data-iconpos='notext' onTouchEnd={props.homeButtonHandler}>Home</a>
     return (
       <div data-role='header' data-position='fixed' data-tap-toggle='false'
         data-theme='b'>
         {backButton}
         <h1>{props.title}</h1>
         {homeButton}
       </div>
     );
    },

  });

  return Header;
});
