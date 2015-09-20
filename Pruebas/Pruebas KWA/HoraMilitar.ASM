	DEFI horamilitar
	DEFI hora
	DEFI minutos
	READI horamilitar
	PUSHI horamilitar
	PUSHKI 100
	MOD
	POPI minutos
	PUSHI horamilitar
	PUSHI minutos
	SUB
	PUSHKI 100
	DIV
	POPI hora
	PUSHI hora
	PUSHKI 12
	CMPLT
	JMPF ETQA
	PUSHI hora
	PUSHKI 0
	CMPEQ
	JMPT ETQC
ETQA: PUSHI hora
	PUSHKI 12
	CMPGT
	JMPT ETQD
ETQB: WRTM 8,son las 
	WRTI hora
	WRTM 1,:
	WRTI minutos
	WRTM 3, am
ETQC: PUSHKI 12
	POPI hora
	JMPT ETQB
ETQD: WRTM 8,son las 
	WRTI hora
	WRTM 1,:
	WRTI minutos
	WRTM 3, pm
	HALT