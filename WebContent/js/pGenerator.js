
 
function generate_pwd (options){
  	var numbers_array = new Array(),
		upper_letters_array = new Array(),
		lower_letters_array = new Array();

	var methods = {
		init : function() {
		
			var settings = $.extend({
				'passwordLength': 8,
				'uppercase': true,
				'lowercase': true,
				'numbers':   true,
			}, options);
					 
			for(var i = 48; i < 58; i++)
				numbers_array.push(i);
			for(i = 65; i < 91; i++)
				upper_letters_array.push(i);
			for(i = 97; i < 123; i++)
				lower_letters_array.push(i);
			
			return methods.generatePassword(settings);

		},
		generatePassword: function(settings) {
			
			var password = new Array(),
				selOptions = settings.uppercase + settings.lowercase + settings.numbers,
				selected = 0,
				no_lower_letters = new Array();
				
			var optionLength = Math.floor(settings.passwordLength / selOptions);
			
			if(settings.uppercase) {
				// uppercase letters
				for(var i = 0; i < optionLength; i++) {
					password.push(String.fromCharCode(upper_letters_array[randomFromInterval(0, upper_letters_array.length - 1)]));	
				}
				
				no_lower_letters = no_lower_letters.concat(upper_letters_array);
				
				selected++;
			}
			
			if(settings.numbers) {
				// numbers letters
				for(var i = 0; i < optionLength; i++) {
					password.push(String.fromCharCode(numbers_array[randomFromInterval(0, numbers_array.length - 1)]));	
				}
				
				no_lower_letters = no_lower_letters.concat(numbers_array);
				
				selected++;
			}
			
			var remained = settings.passwordLength - (selected * optionLength);
			
			if(settings.lowercase) {
				
				for(var i = 0; i < remained; i++) {
					password.push(String.fromCharCode(lower_letters_array[randomFromInterval(0, lower_letters_array.length - 1)]));	
				}
				
			} else {
				
				for(var i = 0; i < remained; i++) {
					password.push(String.fromCharCode(no_lower_letters[randomFromInterval(0, no_lower_letters.length - 1)]));	
				}	
			}
			password = shuffle(password);
			passwordString = password.join('');
			return passwordString;
		}
  	};
	return methods.init();
	
	function shuffle(o){ //v1.0
		for(var j, x, i = o.length; i; j = parseInt(Math.random() * i), x = o[--i], o[i] = o[j], o[j] = x);
		return o;
	};
		
	function randomFromInterval(from, to)
	{
		return Math.floor(Math.random()*(to-from+1)+from);
	};
}
