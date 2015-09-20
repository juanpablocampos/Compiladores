package virtualMachine;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
public class virtualMachine {
    //Contador de la linea actual (PC)  
    static int _currentLine;
    //Dirección de la variable dentro del segmento de datos
    static int _dir;
    //Arreglo de las instrucciones (Segmento de código)
    static byte[] _sc;
    //Contador para variables que son vectores
    static int _index;
    //Segmento de datos con [nombre] - [valor] - [dirección]
    static byte[] _sd;
    //Pila
    static KwaStack _stack = new KwaStack();
    
    public static void main(String[] args) {
        _currentLine = 0;
        _dir = 0;
        _index = 0;
        //GetSC();
        //GetSD();
        RunVirtualMachine();
    }
    public static void RunVirtualMachine(){
    	while(_currentLine <= _sc.length && ByteToInstruction(_sc[_currentLine])!=0){
            switch(ByteToInstruction(_sc[_currentLine])){
                case 1:
                    ReadI();
                    break;
                case 2:
                    ReadD();
                    break;
                case 3:
                    ReadF();
                    break;
                case 4:
                    ReadC();
                    break;
                case 5:
                    ReadS();
                    break;
                case 6:
                    ReadVI();
                    break;
                case 7:
                    ReadVD();
                    break;
                case 8:
                    ReadVF();
                    break;
                case 9:
                    ReadVC();
                    break;
                case 10:
                    ReadVS();
                    break;
                case 11:
                    WRTI();
                    break;
                case 12:
                    WRTD();
                    break;
                case 13:
                    WRTF();
                    break;
                case 14:
                    WRTC();
                    break;
                case 15:
                    WRTS();
                    break;
                case 16:
                    WRTM();
                    break;
                case 17:
                    WRTLN();
                    break;
                case 18:
                    WRTVI();
                    break;
                case 19:
                    WRTVD();
                    break;
                case 20:
                    WRTVC();
                    break;
                case 21:
                    WRTVF();
                    break;
                case 22:
                    WRTVS();
                    break;
                case 23:
                    SETINDEX();
                    break;
                case 24:
                    SETINDEXK();
                    break;
                case 25:
                    POPINDEX();
                    break;
                case 26:
                    PUSHI();
                    break;
                case 27:
                    PUSHD();
                    break;
                case 28:
                    PUSHC();
                    break;
                case 29:
                    PUSHF();
                    break;
                case 30:
                    PUSHS();
                    break;
                case 31:
                    PUSHKI();
                    break;
                case 32:
                    PUSHKF();
                    break;
                case 33:
                    PUSHKD();
                    break;
                case 34:
                    PUSHKC();
                    break;
                case 35:
                    PUSHKS();
                    break;
                case 36:
                    PUSHVI();
                    break;
                case 37:
                    PUSHVF();
                    break;
                case 38:
                    PUSHVD();
                    break;
                case 39:
                    PUSHVC();
                    break;
                case 40:
                    PUSHVS();
                    break;
                case 41:
                    POPI();
                    break;
                case 42:
                    POPD();
                    break;
                case 43:
                    POPC();
                    break;
                case 44:
                    POPF();
                    break;
                case 45:
                    POPS();
                    break;
                case 46:
                    POPVI();
                    break;
                case 47:
                    POPVD();
                    break;
                case 48:
                    POPVC();
                    break;
                case 49:
                    POPVF();
                    break;
                case 50:
                    POPVS();
                    break;
                case 51:
                    CMPEQ();
                    break;
                case 52:
                    CMPNE();
                    break;
                case 53:
                    CMPLT();
                    break;
                case 54:
                    CMPLE();
                    break;
                case 55:
                    CMPGT();
                    break;
                case 56:
                    CMPGE();
                    break;
                case 57:
                    JMP();
                    break;
                case 58:
                    JMPT();
                    break;
                case 59:
                    JMPF();
                    break;
                case 60:
                    ADD();
                    break;
                case 61:
                    SUB();
                    break;
                case 62:
                    MUL();
                    break;
                case 63:
                    DIV();
                    break;
                case 64:
                    MOD();
                    break;
                default:
                    //error
                    _currentLine = _sc.length + 23;
                    break;
            }
        }
    }
    //Leer Segmento de Código
    public static void GetSC() throws IOException{
    	byte[] bytesInFile=Files.readAllBytes(Paths.get("output.KWA"));
    	byte[] segment=new byte[2];
    	segment[0]=bytesInFile[10];
    	segment[1]=bytesInFile[11];
    	
    	_sc=new byte[ByteArrayToSegment(segment)];
    	
    	for(int i=14;i<bytesInFile.length;i++){
    		_sc[i-14]=bytesInFile[i];
    	}
    	
    }
    public static void GetSD() throws IOException{
    	byte[] bytesInFile=Files.readAllBytes(Paths.get("output.KWA"));
    	byte[] segment=new byte[2];
    	segment[0]=bytesInFile[12];
    	segment[1]=bytesInFile[13];
    	_sd=new byte[ByteArrayToSegment(segment)];
    }
    //Metodos
    public static void WRTI(){
        varPrint();
    }
    public static void WRTD(){
        varPrint();
    }
    public static void WRTF(){
        varPrint();
    }
    public static void WRTC(){
        varPrint();
    }
    public static void WRTS(){
        varPrint();
    }
    public static void varPrint(){
    	_currentLine++;
    	_dir = Integer.parseInt(_sc[_currentLine]);
    	System.out.print(GetVariableValue(String.valueOf(_dir)));
    	_currentLine += 2;
    }
    public static void WRTM(){
    	int longitud;
    	_currentLine++;
    	longitud = Integer.parseInt(_sc[_currentLine]);
    	_currentLine++;
    	System.out.print(GetVariableValue(String.valueOf(_dir)));
    	_currentLine += longitud;
    }
    public static void WRTLN(){
    	System.out.println("");
    }
    public static void WRTVI(){
    	_currentLine++;
    	_dir = Integer.parseInt(_sc[_currentLine]);
    	System.out.print(GetVariableValue(String.valueOf(_dir+_index*4)));
    	_currentLine += 2;
    }
    public static void WRTVD(){
    	_currentLine++;
    	_dir = Integer.parseInt(_sc[_currentLine]);
    	System.out.print(GetVariableValue(String.valueOf(_dir+_index*8)));
    	_currentLine += 2;
    }
    public static void WRTVF(){
        _currentLine++;
        _dir = Integer.parseInt(_sc[_currentLine]);
        System.out.print(GetVariableValue(String.valueOf(_dir+_index*4)));
        _currentLine +=2 ;
    }
    public static void WRTVC(){
        _currentLine++;
        _dir = Integer.parseInt(_sc[_currentLine]);
        System.out.print(GetVariableValue(String.valueOf(_dir+_index)));
        _currentLine += 2;
    }
    public static void WRTVS(){
        String StringValue;
        
        _currentLine++;
        _dir = Integer.parseInt(_sc[_currentLine]);
        StringValue=GetStringValue();
        if(StringValue.equals("-1"))
        {
                return;
        }
        System.out.print(StringValue);
        _currentLine += 2;
    }
    public static void ReadI() {
        Scanner scan=new Scanner(System.in);
        _currentLine++;
        try{
            _dir=Integer.parseInt(_sc[_currentLine]);
            }
        catch(Exception e){
                System.out.println(e.getMessage());
        }
        setVariableValue(""+_dir,scan.nextLine(),"0");
        _currentLine+=2;
    }
    public static void ReadD() {
        Scanner scan=new Scanner(System.in);
        _currentLine++;
        try{
            _dir=Integer.parseInt(_sc[_currentLine]);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        setVariableValue(""+_dir,scan.nextLine(),"2");
        _currentLine+=2;
    }
    public static void ReadF(){
        Scanner scan=new Scanner(System.in);
        _currentLine++;
        try{
            _dir=Integer.parseInt(_sc[_currentLine]);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        setVariableValue(""+_dir,scan.nextLine(),"1");
        _currentLine+=2;
    }
    public static void ReadC() {
        Scanner scan=new Scanner(System.in);
        _currentLine++;
        try{
            _dir=Integer.parseInt(_sc[_currentLine]);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        setVariableValue(""+_dir,scan.nextLine(),"3");
        _currentLine+=2;
    }
    public static void ReadS(){
        Scanner scan=new Scanner(System.in);
        _currentLine++;
        try{
            _dir=Integer.parseInt(_sc[_currentLine]);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        setVariableValue(""+_dir,scan.nextLine(),"4");
        _currentLine+=2;
    }
    public static void ReadVI(){
        Scanner scan=new Scanner(System.in);
        _currentLine++;
        try{
            _dir=Integer.parseInt(_sc[_currentLine]);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        setVariableValue(""+(_dir+_index*4),scan.nextLine(),"0");
        _currentLine+=2;
    }
    public static void ReadVD(){
        Scanner scan=new Scanner(System.in);
        _currentLine++;
        try{
            _dir=Integer.parseInt(_sc[_currentLine]);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        setVariableValue(""+(_dir+_index*8),scan.nextLine(),"2");
        _currentLine+=2;
    }
    public static void ReadVF(){
        Scanner scan=new Scanner(System.in);
        _currentLine++;
        try{
            _dir=Integer.parseInt(_sc[_currentLine]);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        setVariableValue(""+(_dir+_index*4),scan.nextLine(),"1");
        _currentLine+=2;
    }
    public static void ReadVC(){
        Scanner scan=new Scanner(System.in);
        _currentLine++;
        try{
            _dir=Integer.parseInt(_sc[_currentLine]);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        setVariableValue(""+(_dir+_index*1),scan.nextLine(),"3");
        _currentLine+=2;
    }
    public static void ReadVS(){
        Scanner scan=new Scanner(System.in);
        _currentLine++;
        try{
            _dir=Integer.parseInt(_sc[_currentLine]);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        //Los strings cambian de tamano por eso se usa otro metodo
        setVariableValueStringArray(scan.nextLine());
        _currentLine+=2;
    }
    public static void setVariableValue(String dir, String newValue,String varType){ 
        boolean foundIt=false;
        for (String[] _sd1 : _sd) {
            //Busca una direccion en la tabla de variables y le asigna un nuevo valor
            if (_sd1[2].equals(dir)) {
                foundIt=true;
                if (_sd1[3].equals(varType)) {
                    _sd1[1] = newValue;
                } else {
                    System.out.println("HORROR, no son tipos de datos compatibles");
                }   
            }
        }
        if(!foundIt)
            System.out.println("HORROR, no se encuentra la direccion en la tabla de datos");
    }
    public static void setVariableValueStringArray(String newValue){ 
        boolean foundIt = false;
        for(int i=0;i<_sd.length;i++){
            //Busca una direccion en la tabla de variables y le asigna un nuevo valor, el string cambia de tamano asi que es diferente
            if(_sd[i][2].equals(_dir+"")){
                foundIt=true;
                if(_sd[i][3].equals("4")){
                    //Como no sabemos el tamano del string, encontramos el vector[0] y le sumamos (index) renglones para encontrar la casilla correcta
                    if(i+_index<_sd.length)
                    _sd[i+_index][1]=newValue;
                    else
                    System.out.println("HORROR, index+_dir se sale del SD (el arreglo no es tan grande)");
                }
                else
                    System.out.println("HORROR, no son tipos de datos compatibles");
            }   
        }
        if(!foundIt)
            System.out.println("HORROR, no se encuentra la direccion en la tabla de datos");
    }
    public static void SETINDEX(){
        _currentLine++;
        _dir=Integer.parseInt(_sc[_currentLine]);
        _index=Integer.parseInt(getVariableValue(_sc[_currentLine]));
        _currentLine+=2;
    }
    public static void SETINDEXK(){
        _currentLine++;
        _index=Integer.parseInt(_sc[_currentLine]);
        _currentLine+=2;
    }
    public static void POPINDEX(){
        try{
            _index = _stack.POPI();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        _currentLine ++;
    }
    public static void JMP(){
        _currentLine++;
        _currentLine=Integer.parseInt(_sc[_currentLine]);
    }
    public static void JMPF(){
        int flag;
        flag=_stack.POPI();
        
        if(flag==0){
            _currentLine++;
            _currentLine=Integer.parseInt(_sc[_currentLine]);
        }
        else
            _currentLine+=2;
    }
    public static void JMPT(){
        int flag;
        flag=_stack.POPI();
        if(flag==1)
        {
            _currentLine++;
            _currentLine=Integer.parseInt(_sc[_currentLine]);
        }
        else
            _currentLine+=2;
    }
    public static void CMPEQ(){
        double var1, var2 = 0;
        int result=0;
        String varString1, varString2, resultString;

        //Entero
        if (_stack.getType() == 0){
            var1 = _stack.POPD();
            varString1 = "";
        }
        else{
        //float
            if (_stack.getType() == 1){
                var1 = _stack.POPD();
                varString1 = "";
            }
            else{
                //double
                if (_stack.getType() == 2){
                    var1 = _stack.POPD();
                    varString1 = "";
                }
                else{
                    //String
                    if (_stack.getType() == 4){
                        varString1 = _stack.POPS();
                        var1 = 0;
                    }
                    else{
                        var1 = 0;
                        varString1 = "";
                    }
                }
            }
        }

        //Entero
        if (_stack.getType() == 0){
            var2 = _stack.POPD();
            if(var1==var2)
            	result = 1;
            else
            	result=0;
            _stack.PUSHI((int)result);
            resultString = "";
        }
        else{
        //float
            if (_stack.getType() == 1){
            	if(var1==var2)
            		result = 1;
            	else
            		result=0;
            	_stack.PUSHI((int)result);
                resultString = "";
            }
            else{
                //double
                if (_stack.getType() == 2){
            		if(var1==var2)
            			result = 1;
            		else
            			result=0;
            			_stack.PUSHI((int)result);
            	        resultString = "";
                }
                else{
                    //String
                    if (_stack.getType() == 4){
                        varString2 = _stack.POPS();
                        varString2 = _stack.POPS();
                        if(varString1.equals(varString2))
                        	result =1;
                        	else
                        	result=0;

						_stack.PUSHI((int)result);
                    }
                    else{
                        result = 0;
                        resultString = "";
                    }
                }
            }
        }
        _currentLine ++;
    }
    public static void CMPNE(){
       double var1, var2 = 0, result;
        String varString1, varString2, resultString;

        //Entero
        if (_stack.getType() == 0){
            var1 = _stack.POPD();
            varString1 = "";
        }
        else{
        //float
            if (_stack.getType() == 1){
                var1 = _stack.POPD();
                varString1 = "";
            }
            else{
                //double
                if (_stack.getType() == 2){
                    var1 = _stack.POPD();
                    varString1 = "";
                }
                else{
                    //String
                    if (_stack.getType() == 4){
                        varString1 = _stack.POPS();
                        var1 = 0;
                    }
                    else{
                        var1 = 0;
                        varString1 = "";
                    }
                }
            }
        }

        //Entero
        if (_stack.getType() == 0){
            var2 = _stack.POPD();
            if(var1!=var2)
            	result = 1;
            else
            	result=0;
            _stack.PUSHI((int)result);
            resultString = "";
        }
        else{
        //float
            if (_stack.getType() == 1){
            	if(var1!=var2)
            		result = 1;
            	else
            		result=0;
            	_stack.PUSHI((int)result);
                resultString = "";
            }
            else{
                //double
                if (_stack.getType() == 2){
            		if(var1!=var2)
            			result = 1;
            		else
            			result=0;
            			_stack.PUSHI((int)result);
            	        resultString = "";
                }
                else{
                    //String
                    if (_stack.getType() == 4){
                        varString2 = _stack.POPS();
                        if(!varString1.equals(varString2))
                        	result =1;
                        	else
                        	result=0;

						_stack.PUSHI((int)result);

                    }
                    else{
                        result = 0;
                        resultString = "";
                    }
                }
            }
        }
        _currentLine ++;
    }
    public static void CMPLT(){
        double var1, var2 = 0, result;
         String varString1, varString2, resultString;

         //Entero
         if (_stack.getType() == 0){
             var1 = _stack.POPD();
             varString1 = "";
         }
         else{
         //float
             if (_stack.getType() == 1){
                 var1 = _stack.POPD();
                 varString1 = "";
             }
             else{
                 //double
                 if (_stack.getType() == 2){
                     var1 = _stack.POPD();
                     varString1 = "";
                 }
                 else{
                     //String
                     if (_stack.getType() == 4){
                         varString1 = _stack.POPS();
                         var1 = 0;
                     }
                     else{
                         var1 = 0;
                         varString1 = "";
                     }
                 }
             }
         }

         //Entero
         if (_stack.getType() == 0){
             var2 = _stack.POPD();
             if(var1<var2)
             	result = 1;
             else
             	result=0;
             _stack.PUSHI((int)result);
             resultString = "";
         }
         else{
         //float
             if (_stack.getType() == 1){
             	if(var1<var2)
             		result = 1;
             	else
             		result=0;
             	_stack.PUSHI((int)result);
                 resultString = "";
             }
             else{
                 //double
                 if (_stack.getType() == 2){
             		if(var1<var2)
             			result = 1;
             		else
             			result=0;
             			_stack.PUSHI((int)result);
             	        resultString = "";
                 }
                 else{
                     //String
                     if (_stack.getType() == 4){
                         varString2 = _stack.POPS();
                         if(varString1.compareTo(varString2)<0)
                         	result =1;
                         	else
                         	result=0;

 						_stack.PUSHI((int)result);

                     }
                     else{
                         result = 0;
                         resultString = "";
                     }
                 }
             }
         }
        _currentLine ++;
    }
    public static void CMPLE(){
        double var1, var2 = 0, result;
         String varString1, varString2, resultString;

         //Entero
         if (_stack.getType() == 0){
             var1 = _stack.POPD();
             varString1 = "";
         }
         else{
         //float
             if (_stack.getType() == 1){
                 var1 = _stack.POPD();
                 varString1 = "";
             }
             else{
                 //double
                 if (_stack.getType() == 2){
                     var1 = _stack.POPD();
                     varString1 = "";
                 }
                 else{
                     //String
                     if (_stack.getType() == 4){
                         varString1 = _stack.POPS();
                         var1 = 0;
                     }
                     else{
                         var1 = 0;
                         varString1 = "";
                     }
                 }
             }
         }

         //Entero
         if (_stack.getType() == 0){
             var2 = _stack.POPD();
             if(var1<=var2)
             	result = 1;
             else
             	result=0;
             _stack.PUSHI((int)result);
             resultString = "";
         }
         else{
         //float
             if (_stack.getType() == 1){
             	if(var1<=var2)
             		result = 1;
             	else
             		result=0;
             	_stack.PUSHI((int)result);
                 resultString = "";
             }
             else{
                 //double
                 if (_stack.getType() == 2){
             		if(var1<=var2)
             			result = 1;
             		else
             			result=0;
             			_stack.PUSHI((int)result);
             	        resultString = "";
                 }
                 else{
                     //String
                     if (_stack.getType() == 4){
                         varString2 = _stack.POPS();
                         if(varString1.compareTo(varString2)<=0)
                         	result =1;
                         	else
                         	result=0;

 						_stack.PUSHI((int)result);

                     }
                     else{
                         result = 0;
                         resultString = "";
                     }
                 }
             }
         }
        _currentLine ++;
    }
    public static void CMPGT(){
        double var1, var2 = 0, result;
         String varString1, varString2, resultString;

         //Entero
         if (_stack.getType() == 0){
             var1 = _stack.POPD();
             varString1 = "";
         }
         else{
         //float
             if (_stack.getType() == 1){
                 var1 = _stack.POPD();
                 varString1 = "";
             }
             else{
                 //double
                 if (_stack.getType() == 2){
                     var1 = _stack.POPD();
                     varString1 = "";
                 }
                 else{
                     //String
                     if (_stack.getType() == 4){
                         varString1 = _stack.POPS();
                         var1 = 0;
                     }
                     else{
                         var1 = 0;
                         varString1 = "";
                     }
                 }
             }
         }

         //Entero
         if (_stack.getType() == 0){
             var2 = _stack.POPD();
             if(var1>var2)
             	result = 1;
             else
             	result=0;
             _stack.PUSHI((int)result);
             resultString = "";
         }
         else{
         //float
             if (_stack.getType() == 1){
             	if(var1>var2)
             		result = 1;
             	else
             		result=0;
             	_stack.PUSHI((int)result);
                 resultString = "";
             }
             else{
                 //double
                 if (_stack.getType() == 2){
             		if(var1>var2)
             			result = 1;
             		else
             			result=0;
             			_stack.PUSHI((int)result);
             	        resultString = "";
                 }
                 else{
                     //String
                     if (_stack.getType() == 4){
                         varString2 = _stack.POPS();
                         if(varString1.compareTo(varString2)>0)
                         	result =1;
                         	else
                         	result=0;

 						_stack.PUSHI((int)result);

                     }
                     else{
                         result = 0;
                         resultString = "";
                     }
                 }
             }
         }
        _currentLine ++;
    }
    public static void CMPGE(){
         double var1, var2 = 0, result;
          String varString1, varString2, resultString;

          //Entero
          if (_stack.getType() == 0){
              var1 = _stack.POPD();
              varString1 = "";
          }
          else{
          //float
              if (_stack.getType() == 1){
                  var1 = _stack.POPD();
                  varString1 = "";
              }
              else{
                  //double
                  if (_stack.getType() == 2){
                      var1 = _stack.POPD();
                      varString1 = "";
                  }
                  else{
                      //String
                      if (_stack.getType() == 4){
                          varString1 = _stack.POPS();
                          var1 = 0;
                      }
                      else{
                          var1 = 0;
                          varString1 = "";
                      }
                  }
              }
          }

          //Entero
          if (_stack.getType() == 0){
              var2 = _stack.POPD();
              if(var1>=var2)
              	result = 1;
              else
              	result=0;
              _stack.PUSHI((int)result);
              resultString = "";
          }
          else{
          //float
              if (_stack.getType() == 1){
              	if(var1>=var2)
              		result = 1;
              	else
              		result=0;
              	_stack.PUSHI((int)result);
                  resultString = "";
              }
              else{
                  //double
                  if (_stack.getType() == 2){
              		if(var1>=var2)
              			result = 1;
              		else
              			result=0;
              			_stack.PUSHI((int)result);
              	        resultString = "";
                  }
                  else{
                      //String
                      if (_stack.getType() == 4){
                          varString2 = _stack.POPS();
                          if(varString1.compareTo(varString2)>=0)
                          	result =1;
                          	else
                          	result=0;

  						_stack.PUSHI((int)result);

                      }
                      else{
                          result = 0;
                          resultString = "";
                      }
                  }
              }
          }
        _currentLine ++;
    }
    public static String getVariableValue(String realDir){
        int counter=0;
        while(counter<_sd.length && !_sd[counter][2].equals(realDir)){
            if(_sd[counter][2].equals(realDir)){
                return _sd[counter][1];
            }
            counter++;
        }
        return "-1";
    }
    public static String getVariableDir(String variableName){
        int counter=0;
        while(counter<_sd.length && !_sd[counter][0].equals(variableName)){
            if(_sd[counter][0].equals(variableName)){
                return _sd[counter][2];
            }
            counter++;
        }
        return "-1";
    }
    public static String getVariableType(String realDir){
        int counter=0;
        while(counter<_sd.length && !_sd[counter][2].equals(realDir)){
            if(_sd[counter][2].equals(realDir)){
                return _sd[counter][3];
            }
            counter++;
        }
        return "-1";
    }
    public static void PUSHI(){
        int valueInt;
        _currentLine++;
        _dir = Integer.parseInt(_sc[_currentLine]);
        valueInt = Integer.parseInt(getVariableValue(String.valueOf(_dir)));
        _stack.PUSHI(valueInt);
        _currentLine = _currentLine + 3;
    }
    public static void PUSHD(){
        double valueDouble;
        _currentLine++;
        _dir = Integer.parseInt(_sc[_currentLine]);
        valueDouble = Double.parseDouble(getVariableValue(String.valueOf(_dir)));
        _stack.PUSHD(valueDouble);
        _currentLine = _currentLine + 7;
    }
    public static void PUSHC(){
        char valueChar;
        _currentLine++;
        _dir = Integer.parseInt(_sc[_currentLine]);
        valueChar = getVariableValue(String.valueOf(_dir)).charAt(0);        
        _stack.PUSHC(valueChar);
        _currentLine = _currentLine + 1;
    }
    public static void PUSHF(){
        float valueFloat;
        _currentLine++;
        _dir = Integer.parseInt(_sc[_currentLine]);
        valueFloat =Float.parseFloat(getVariableValue(String.valueOf(_dir)));       
        _stack.PUSHF(valueFloat);
        _currentLine = _currentLine + 3;
    }
    public static void PUSHS(){
        String valueString;
        _currentLine++;
        _dir = Integer.parseInt(_sc[_currentLine]);
        valueString =getVariableValue(String.valueOf(_dir));       
        _stack.PUSHS(valueString);
        _currentLine = _currentLine + 3;
    }
    public static void PUSHKI(){
        //Cambiar la logica de las constantes
        //Tomar el valor directamente del vector _sc
        int valueKInt;
        _currentLine++;
        valueKInt = Integer.parseInt(_sc[_currentLine]);
        //valueKInt = Integer.parseInt(_sc[_currentLine]);
        _stack.PUSHI(valueKInt);
        _currentLine = _currentLine + 3;
    }
    public static void PUSHKF(){
        float valueFloat;
        _currentLine++;
        _dir = Integer.parseInt(_sc[_currentLine]);
        valueFloat =Float.parseFloat(getVariableValue(String.valueOf(_dir)));
        _stack.PUSHF(valueFloat);
        _currentLine = _currentLine + 3;
    }
    public static void PUSHKD(){
        double valueDouble;
        _currentLine++;
        _dir = Integer.parseInt(_sc[_currentLine]);
        valueDouble = Double.parseDouble(getVariableValue(String.valueOf(_dir)));
        _stack.PUSHD(valueDouble);
        _currentLine = _currentLine + 7;
    }
    public static void PUSHKC(){
        char valueChar;
        _currentLine++;
        _dir = Integer.parseInt(_sc[_currentLine]);
        valueChar = getVariableValue(String.valueOf(_dir)).charAt(0);
        _stack.PUSHC(valueChar);
        _currentLine = _currentLine + 1;
    }
    public static void PUSHKS(){
        String valueString;
        _currentLine++;
        _dir = Integer.parseInt(_sc[_currentLine]);
        valueString = getVariableValue(String.valueOf(_dir));
        _stack.PUSHS(valueString);
        int longValueString = valueString.length();
        _currentLine = longValueString + 2;
    }   
    public static void PUSHVI(){
        int valueInt = 0;
        _currentLine++;
        valueInt = GetVariableValue(GetDir(),valueInt);
        _stack.PUSHI(valueInt);
        _currentLine += 2;
    }
    public static void PUSHVF(){
        float valueFloat = 0;
        _currentLine++;
        valueFloat = GetVariableValue(GetDir(),valueFloat);
        _stack.PUSHF(valueFloat);
        _currentLine += 2;
    }
    public static void PUSHVD(){        
        double valueDouble = 0;
        _currentLine++;
        valueDouble = GetVariableValue(GetDir(),valueDouble);
        _stack.PUSHD(valueDouble);
        _currentLine += 2;
    }
    public static void PUSHVC(){
        char valueChar = ' ';
        _currentLine++;
        valueChar = GetVariableValue(GetDir(),valueChar);
        _stack.PUSHC(valueChar);
        _currentLine += 2;
    }
    public static void PUSHVS(){
        String valueString = "";
        _currentLine++;
        valueString = GetVariableValue(GetDir(),valueString);
        _stack.PUSHS(valueString);
        _currentLine += 2;
    }
    public static void POPI(){        
        int poppedVariable=0;
        try{
            poppedVariable = _stack.POPI();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        _currentLine ++;
        String varAddress =_sc[_currentLine];
        setVariableValue(varAddress,""+poppedVariable, "0");
        _currentLine += 2; 
    }
    public static void POPF(){ 
        float poppedVariable=0.0f;
        try{
            poppedVariable = _stack.POPI();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        _currentLine ++;
        String varAddress =_sc[_currentLine];
        setVariableValue(varAddress,""+poppedVariable, "1");
        _currentLine += 2; 
    }
    public static void POPD(){ 
        double poppedVariable=0.0;
        try{
            poppedVariable = _stack.POPI();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        _currentLine ++;
        String varAddress =_sc[_currentLine];
        setVariableValue(varAddress,""+poppedVariable, "2");
        _currentLine += 2;
    }
    public static void POPC(){ 
        char poppedVariable=' ';
        try{
            poppedVariable = (char)_stack.POPI();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        _currentLine ++;
        String varAddress =_sc[_currentLine];
        setVariableValue(varAddress,""+poppedVariable, "3");
        _currentLine += 2; 
    }
    public static void POPS(){ 
        String poppedVariable="";
        try{
            poppedVariable = Integer.toString(_stack.POPI());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        _currentLine ++;
        String varAddress =_sc[_currentLine];
        setVariableValue(varAddress,""+poppedVariable, "4");
        _currentLine += 2; 
    }
    public static void POPVI(){
        int poppedVariable = 0;
        try{
            poppedVariable = _stack.POPI();
            _currentLine++;
            SetVariableValue(GetDir(),poppedVariable);
            _currentLine += 2;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
      }
    public static void POPVF(){ 
        float poppedVariable = 0.0f;
        try{
            poppedVariable = _stack.POPI();
            _currentLine ++;
            SetVariableValue(GetDir(),poppedVariable);
            _currentLine += 2;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void POPVD(){ 
        double poppedVariable = 0.0;
        try{
            poppedVariable = _stack.POPI();
            _currentLine ++;
            SetVariableValue(GetDir(),poppedVariable);
            _currentLine += 2;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }     
    }
    public static void POPVC(){ 
        char poppedVariable = ' ';
        try{
            poppedVariable = _stack.POPC();
            _currentLine ++;
            SetVariableValue(GetDir(), poppedVariable);
            _currentLine += 2;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void POPVS(){ 
        String poppedVariable="";
        try{
            poppedVariable = _stack.POPS();
            _currentLine ++;
            SetVariableValue(GetDir(), poppedVariable);
            _currentLine += 2;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static String GetVariableValue(String realDir){
        int counter=0;
        while(counter<_sd.length && !_sd[counter][2].equals(realDir)){
                if(_sd[counter][2].equals(realDir)){
                        return _sd[counter][1];
                }
                counter++;
        }
        return "-1";
    }
    public static String GetVariableDir(String variableName){
        int counter=0;
        while(counter<_sd.length && !_sd[counter][0].equals(variableName)){
                if(_sd[counter][0].equals(variableName)){
                        return _sd[counter][2];
                }
                counter++;
        }
        return "-1";
    }
    public static String GetVariableValueType(String realDir){
        int counter=0;
        while(counter<_sd.length && !_sd[counter][2].equals(realDir)){
                if(_sd[counter][2].equals(realDir)){
                        return _sd[counter][3];
                        }
                                counter++;
        }
        return "-1";
    }
    public static String GetStringValue(){
        int InitialRow = 0;
        
        for (String[] _sd1 : _sd) {
            if (_sd1[2].equals(_dir+"")) {
                InitialRow = Integer.parseInt(_sd1[2]);
                break;
            }
        }

        if(InitialRow+_index >= _sd.length){
            System.out.print("HORROR HORROR, problema en el segmento de datos, es muy corto!!!");
            return -1+"";
        }
        return String.valueOf(_sd[InitialRow+_index]);	
    }
    public static void ADD(){
        double var1, var2, result;
        String varString1, varString2, resultString;
        
        //Entero
        if (_stack.getType() == 0){
            var1 = _stack.POPD();
            varString1 = "";
        }
        else{
        //float
            if (_stack.getType() == 1){
                var1 = _stack.POPD();
                varString1 = "";
            }
            else{
                //double
                if (_stack.getType() == 2){
                    var1 = _stack.POPD();
                    varString1 = "";
                }
                else{
                    //String
                    if (_stack.getType() == 4){
                        varString1 = _stack.POPS();
                        var1 = 0;
                    }
                    else{
                        var1 = 0;
                        varString1 = "";
                    }
                }
            }
        }

        //Entero
        if (_stack.getType() == 0){
            var2 = _stack.POPD();
            var2 = var1 + var2;
            result = var2;
            _stack.PUSHI((int)result);
            resultString = "";
        }
        else{
        //float
            if (_stack.getType() == 1){
                var2 = _stack.POPD();
                var2 = var1 + var2;
                result = var2;
                _stack.PUSHF((float)result);
                resultString = "";
            }
            else{
                //double
                if (_stack.getType() == 2){
                    var2 = _stack.POPD();
                    var2 = var1 + var2;
                    result = var2;
                    _stack.PUSHD(result);
                    resultString = "";
                }
                else{
                    //String
                    if (_stack.getType() == 4){
                        varString2 = _stack.POPS();
                        varString2 = varString1 + varString2;
                        resultString = varString2;
                        _stack.PUSHS(resultString);
                        result = 0;
                    }
                    else{ 
                        result = 0;
                        resultString = "";
                    }
                }
            }
        }
        _currentLine ++;
    }
    public static void SUB(){
        double var1, var2, result;
        
        //Entero
        if (_stack.getType() == 0){
            var1 = _stack.POPD();
        }
        else{
        //float
            if (_stack.getType() == 1){
                var1 = _stack.POPD();
            }
            else{
                //double
                if (_stack.getType() == 2){
                    var1 = _stack.POPD();
                }
                else
                    var1 = 0;
                
            }
        }

        //Entero
        if (_stack.getType() == 0){
            var2 = _stack.POPD();
            var2 = var1 - var2;
            result = var2;
            _stack.PUSHI((int)result);
        }
        else{
        //float
            if (_stack.getType() == 1){
                var2 = _stack.POPD();
                var2 = var1 - var2;
                result = var2;
                _stack.PUSHF((float)result);
            }
            else{
                //double
                if (_stack.getType() == 2){
                    var2 = _stack.POPD();
                    var2 = var1 - var2;
                    result = var2;
                    _stack.PUSHD(result);
                }
                else{
                    result = 0;
                }
            }
        }
        _currentLine ++;
    }
    public static void MUL(){
        double var1, var2, result;
        
        //Entero
        if (_stack.getType() == 0){
            var1 = _stack.POPD();
        }
        else{
        //float
            if (_stack.getType() == 1){
                var1 = _stack.POPD();
            }
            else{
                //double
                if (_stack.getType() == 2){
                    var1 = _stack.POPD();
                }
                else
                    var1 = 0;
            }
        }

        //Entero
        if (_stack.getType() == 0){
            var2 = _stack.POPD();
            var2 = var1 * var2;
            result = var2;
            _stack.PUSHI((int)result);
        }
        else{
        //float
            if (_stack.getType() == 1){
                var2 = _stack.POPD();
                var2 = var1 * var2;
                result = var2;
                _stack.PUSHF((float)result);
            }
            else{
                //double
                if (_stack.getType() == 2){
                    var2 = _stack.POPD();
                    var2 = var1 * var2;
                    result = var2;
                    _stack.PUSHD(result);
                }
                else
                    result = 0;
            }
        }
        _currentLine ++;
    }
    public static void DIV(){
        double var1, var2, result;
        
        //Entero
        if (_stack.getType() == 0){
            var1 = _stack.POPD();
        }
        else{
        //float
            if (_stack.getType() == 1){
                var1 = _stack.POPD();
            }
            else{
                //double
                if (_stack.getType() == 2){
                    var1 = _stack.POPD();
                }
                else
                    var1 = 0;
                
            }
        }

        //Entero
        if (_stack.getType() == 0){
            var2 = _stack.POPD();
            if(var2 != 0){
                var2 = var1 / var2;
                result = var2;
                _stack.PUSHI((int)result);
            }
            else
                System.out.println("Can't divide by 0");
        }
        else{
        //float
            if (_stack.getType() == 1){
                var2 = _stack.POPD();
                if(var2 != 0){
                    var2 = var1 / var2;
                    result = var2;
                    _stack.PUSHF((float)result);
                }
                else
                    System.out.println("Can't divide by 0");
            }
            else{
                //double
                if (_stack.getType() == 2){
                    var2 = _stack.POPD();
                    if(var2 != 0){
                        var2 = var1 / var2;
                        result = var2;
                        _stack.PUSHD(result);
                    }
                    else
                        System.out.println("Can't divide by 0");
                }
                else{
                    result = 0;
                }
            }
        }
        _currentLine ++;
    }
    public static void MOD(){
        double var1, var2, result;
        
        //Entero
        if (_stack.getType() == 0){
            var1 = _stack.POPD();
        }
        else{
        //float
            if (_stack.getType() == 1){
                var1 = _stack.POPD();
            }
            else{
                //double
                if (_stack.getType() == 2){
                    var1 = _stack.POPD();
                }
                else
                    var1 = 0;
                
            }
        }

        //Entero
        if (_stack.getType() == 0){
            var2 = _stack.POPD();
            if(var2 != 0){
                var2 = var1 % var2;
                result = var2;
                _stack.PUSHI((int)result);
            }
            else
                System.out.println("Can't divide by 0");
        }
        else{
        //float
            if (_stack.getType() == 1){
                var2 = _stack.POPD();
                if(var2 != 0){
                    var2 = var1 % var2;
                    result = var2;
                    _stack.PUSHF((float)result);
                }
                else
                    System.out.println("Can't divide by 0");
            }
            else{
                //double
                if (_stack.getType() == 2){
                    var2 = _stack.POPD();
                    if(var2 != 0){
                        var2 = var1 % var2;
                        result = var2;
                        _stack.PUSHD(result);
                    }
                    else
                        System.out.println("Can't divide by 0");
                }
                else{
                    result = 0;
                }
            }
        }
        _currentLine ++;
    }
    //******BYTE CONVERSIONS*********
    

    public static int getVariableTypeCode(String instruction){
    	switch(instruction.charAt(instruction.length()-1)){
	    	case 'I':
	    		return 0;    	
	    	case 'F':
	    		return 1;    	
	    	case 'D':
	    		return 2;    	
	    	case 'S':
	    	case 'M':
	    		return 3;    	
	    	case 'C':
	    		return 4;
	    	default:
	    		return -1;
    	}
    }
    public static int getInstructionVariableSize(int instructionCode){
    	switch(instructionCode){
    		//READs
    		case 1:case 2:case 3:case 4:case 5:case 6:case 7:case 8:case 9:case 10:
    		//WRTs
    		case 11:case 12:case 13:case 14:case 15:
    		//WRTVs
    		case 18:case 19:case 20:case 21:case 22:
    		//SETINDEX & POPINDEX
    		case 23:case 25:case 26:case 27:case 28:case 29:case 30:
    		//PUSHVs
    		case 36:case 37:case 38:case 39:case 40:
    		//POPs
    		case 41:case 42:case 43:case 44:case 45:case 46:case 47:case 48:case 49:
    		//JMPs
    		case 50:case 57:case 58:case 59:
    			return 2;
    		//SETINDEXK PUSHKI PUSHKF
    		case 24:case 31:case 32:
    			return 4;
    		//PUSHKD
    		case 33:
    			return 8;
    		//PUSHKC
    		case 34:
    			return 1; 	
    		//constant string
    		case 16:case 35:
    			return -1;
    		//CMP & Arithmetic
    		default:
    			return 0;
    	}
    }
    
    public static int ByteToStringLength(byte byteStringLength){
    	return byteStringLength & 0xff;
    }
    public static int ByteToInstruction(byte byteInstruction){
    	return byteInstruction & 0xff;
    }
    public static int ByteArrayToInt(byte[] byteArray) {
	    return ByteBuffer.wrap(byteArray).getInt();
	}
    public static float ByteArrayToFloat(byte[] byteArray){
	    return ByteBuffer.wrap(byteArray).getFloat();
	}
    public static double ByteArrayToDouble(byte[] byteArray) {
	    return ByteBuffer.wrap(byteArray).getDouble();
	}
    public static char ByteToChar(byte byteArray) {
		return (char)(byteArray & 0xff);
	}
    public static int ByteArrayToSegment(byte[] segment){
    	return ((segment[0] & 0xff) << 8) | (segment[1] & 0xff);
    }
    public static int ByteArrayToDir(byte[] dir){
    	return ((dir[0] & 0xff) << 8) | (dir[1] & 0xff);
    }
    
    public static byte StringLengthToByte(int stringLengthToConvert){
    	return (byte)stringLengthToConvert;
 	}
    public static byte InstructionToByte(int instructionToConvert){
    	return (byte)instructionToConvert;
 	}
    public static byte[] IntToByteArray(int numberToConvert){
	   return ByteBuffer.allocate(4).putInt(numberToConvert).array();
	}
    public static byte[] FloatToByteArray(float numberToConvert)
	{
 	   return ByteBuffer.allocate(4).putFloat(numberToConvert).array();
	} 
    public static byte[] DoubleToByteArray(double numberToConvert)
	{
 	   return ByteBuffer.allocate(8).putDouble(numberToConvert).array();
	}
    public static byte CharToByte(char charToConvert)
	{
    	return (byte)charToConvert;
	}
    public static byte[] SegmentsToByteArray(int segmentSize){
    	byte[] segmentIn2Bytes=new byte[2];
    	segmentIn2Bytes[1]=(byte)(segmentSize & 0xFF);
    	segmentIn2Bytes[0]=(byte)((segmentSize>>8) & 0xFF);
    	return segmentIn2Bytes;
    }
    public static byte[] DirToByteArray(int dir){
    	byte[] segmentIn2Bytes=new byte[2];
    	segmentIn2Bytes[1]=(byte)(dir & 0xFF);
    	segmentIn2Bytes[0]=(byte)((dir>>8) & 0xFF);
    	return segmentIn2Bytes;
    }

}

