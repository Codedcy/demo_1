/**
 * 
 */

function spotInfoReader(filePath){
	alert(1);
	var fso, ts,s,html,flag=0;
	var ForReading = 1;
	fso = new ActiveXObject("Scripting.FileSystemObject");
	ts = fso.OpenTextFile(filePath, ForReading);
	while((s = ts.ReadLine())!=null){
		if(s[0] == 'T'){
			if(flag==1){
				html+='</textarea>';
			}
			html+='<h2>'+s.substr(1)+'</h2>';
			flag=2;
		}else if(s[0] == 'H'){
			html+='<strong>'+s.substr(1)+'</strong>';
		}else{
			if(flag==2){
				html+='<textarea>';
				flag=1;
			}
			html+=s;
		}
		html+='</textarea>';
	}
	ts.close();
	return html;
	
}
