/* 代码整理：懒人之家 lanrenzhijia.com */
$(function(){

	var note = $('#note');
	var search = $('#search');
	
	var saveTimer,
		lineHeight = parseInt(note.css('line-height')),
		minHeight = parseInt(note.css('min-height')),
		lastHeight = minHeight,
		newHeight = 0,
		newLines = 0;
		
	var countLinesRegex = new RegExp('\n','g');
	
	// The input event is triggered on key press-es,
	// cut/paste and even on undo/redo.
	
	note.on('input',function(e){
		
		// Clearing the timeout prevents
		// saving on every key press
		clearTimeout(saveTimer);
		saveTimer = setTimeout(ajaxSaveNote, 2000);
		
		// Count the number of new lines
		newLines = note.val().match(countLinesRegex);
		
		if(!newLines){
			newLines = [];
		}
		
		// Increase the height of the note (if needed)
		newHeight = Math.max((newLines.length + 1)*lineHeight, minHeight);
		
		// This will increase/decrease the height only once per change
		if(newHeight != lastHeight){
			if(newHeight < 400){
				note.height(newHeight);
				lastHeight = newHeight;
			}
		}
	}).trigger('input');	// This line will resize the note on page load
	
	function ajaxSaveNote(){
		
	}
	search.on('blur',function(){
		var weizhi = note.val().indexOf(search.val());
		if(weizhi == -1){
			search.css("background-color","#FF7256")
		}else{
			search.css("background-color","#f7f9ee")
			if(search.val()){
				note.selectRange(weizhi,weizhi + search.val().length);
			}
		}
	})
	
});
$.fn.selectRange = function(start, end) {
    return this.each(function() {
        if (this.setSelectionRange) {
            this.focus();
            this.setSelectionRange(start, end);
        } else if (this.createTextRange) {
            var range = this.createTextRange();
            range.collapse(true);
            range.moveEnd('character', end);
            range.moveStart('character', start);
            range.select();
        }
    });
};
