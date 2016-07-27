define(['underscore', 'util/AjaxUtil', 'promise', ], function(_, AjaxUtil, P) {
  
  return {
    loadLexicon: function(){
      var self = this;
      return new Promise(function(resolve, reject){
        AjaxUtil.getJSON('js/app/lexicon/lexicon.json', function(lexicon){
          self.lexicon = lexicon;
          resolve();
        });
      });
    },
    
    getLexicon: function(){
      if(!this.lexicon){
        this.loadLexicon();
        return null;
      }
      return this.lexicon;
    },
    
    getTypes: function(){
      var lexicon = this.getLexicon();
      return lexicon ? _.keys(lexicon) : null; 
    },
    
    getRandomWords: function(selectedTypes){
      var types, type, wordsArr;
      
      function randomIndex(len){
        return Math.floor(Math.random() * len);
      }
      
      types = selectedTypes.length === 0 ? this.getTypes() : selectedTypes,
      wordsArr = this.lexicon[types[randomIndex(types.length)]];
      return wordsArr[randomIndex(wordsArr.length)];
    },
  };

});