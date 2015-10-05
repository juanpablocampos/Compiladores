DEFVI matriculas,3
DEFVS nombres,3
DEFI counter

PUSHKI 0
POPI counter

ETQPIDEDATOS:
	SETINDEX counter
	WRTM 10,Matricula:
	READVI matriculas
	WRTM 7,Nombre:
	READVS nombres
	
	PUSHI counter
	PUSHKI 1
	ADD
	POPI counter
	PUSHI counter
	PUSHKI 3
	
	CMPEQ
	JMPF ETQPIDEDATOS

PUSHKI 0
POPI counter

DEFI internalCounter
DEFI tmpMat
DEFS 50,tmpNombre

ETQORDENA:
	PUSHI counter
	POPI internalCounter
ETQCOMPARACION:
	SETINDEX counter
	PUSHVI matriculas
	WRTVI matriculas
	WRTLN
	SETINDEX internalCounter
	PUSHVI matriculas
	WRTVI matriculas
	WRTLN
	CMPGT
	JMPT ETQCAMBIO
	JMP ETQINTERNALCOUNTER
	ETQCAMBIO:
		WRTM 4,hola
		PUSHVI matriculas
		POPI tmpMat
		PUSHVS nombres
		POPS tmpNombre
		
		SETINDEX counter
		PUSHVI matriculas
		PUSHVS nombres
		SETINDEX internalCounter
		POPVS nombres
		POPVI matriculas
		
		SETINDEX counter
		PUSHS tmpNombre
		PUSHI tmpMat
		POPVI matriculas
		POPVS nombres
		
	ETQINTERNALCOUNTER:
		PUSHKI 1
		PUSHI internalCounter
		ADD
		POPI internalCounter
		PUSHI internalCounter
		PUSHKI 3
		CMPEQ
		JMPT ETQCOUNTER
		JMP ETQCOMPARACION

	ETQCOUNTER:
		PUSHKI 1
		PUSHI counter
		ADD
		POPI counter
		PUSHI counter
		PUSHKI 3
		CMPEQ
		JMPF ETQORDENA
	
PUSHKI 0
POPI counter
	
ETQIMPRIMIR:
	SETINDEX counter
	WRTVI matriculas
	WRTVS nombres 
	PUSHKI 1
	PUSHI counter
	ADD
	POPI counter
	PUSHI counter
	PUSHKI 3
	CMPEQ
	JMPF ETQIMPRIMIR
	
HALT