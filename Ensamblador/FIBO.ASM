		DEFI 	A
		DEFI 	B
		DEFI 	C
		DEFI 	I
		PUSHKI 	0
		POPI 	A
		PUSHKI 	1
		POPI	B
		PUSHKI  1
		POPI	C
		PUSHKI	1
		POPI	I
ETQA:	PUSHI	I
		PUSHKI	10
		CMPLE	
		JMPF	ETQB
		WRTI	A
		WRTLN
		PUSHI	B
		POPI	A
		PUSHI	C
		POPI	B
		PUSHI	A
		PUSHI	B
		ADD
		POPI	C
		PUSHKI	1
		PUSHI	I
		ADD
		POPI	I
		JMP 	ETQA
ETQB:	HALT
		
		