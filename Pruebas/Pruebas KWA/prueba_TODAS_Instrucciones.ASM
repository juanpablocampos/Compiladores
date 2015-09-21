DEFI varInt
DEFD varDouble
DEFF varFloat
DEFC varChar
DEFS 10,varString

DEFVI arrayInt,4
DEFVD arrayDouble,4
DEFVF arrayFloat,4
DEFVC arrayChar,4
DEFVS arrayString,4


DEFI primerNumero
DEFI segundoNumero
;----------OPERACIONESCONINT-----------

READI varInt

PUSHI varInt
PUSHI varInt
ADD

POPI varInt
PUSHI varInt
PUSHKI 2
SUB

POPI varInt
PUSHI varInt
PUSHI varInt
MUL

POPI varInt
PUSHI varInt
PUSHI varInt
DIV

POPI varInt
PUSHI varInt
PUSHI varInt
MOD

POPI varInt
WRTI varInt
WRTLN
;----------OPERACIONESCONDOUBLE-----------

READD varDouble

PUSHD varDouble
PUSHD varDouble
ADD

POPD varDouble
PUSHD varDouble
PUSHKD 2.2
SUB

POPD varDouble
PUSHD varDouble
PUSHD varDouble
MUL

POPD varDouble
PUSHD varDouble
PUSHD varDouble
DIV

POPD varDouble
PUSHD varDouble
PUSHD varDouble
MOD

POPD varDouble
WRTD varDouble
WRTLN
;----------OPERACIONESCONFLOAT-----------

READF varFloat

PUSHF varFloat
PUSHF varFloat
ADD

POPF varFloat
PUSHF varFloat
PUSHKF 2.2
SUB

POPF varFloat
PUSHF varFloat
PUSHF varFloat
MUL

POPF varFloat
PUSHF varFloat
PUSHF varFloat
DIV

POPF varFloat
PUSHF varFloat
PUSHF varFloat
MOD

POPF varFloat
WRTF varFloat
WRTLN
;----------OPERACIONESCONCHAR-----------

READC varChar

PUSHC varChar
POPC varChar

WRTC varChar
WRTLN

;----------OPERACIONESCONSTRING-----------

READS varString

PUSHS varString
PUSHS varString
ADD
POPS varString

WRTS varString
WRTLN

;----------OPERACIONESCONINDEX-----------
;PUSHKI 0
;POPINDEX
PUSHKI 0
POPI varInt
SETINDEX varInt
SETINDEXK 0

;----------OPERACIONESCONVECTORINT-----------


READVI arrayInt
PUSHVI arrayInt
POPVI arrayInt

WRTVI arrayInt
WRTLN

;----------OPERACIONESCONVECTORDOUBLE-----------


READVD arrayDouble
PUSHVD arrayDouble
POPVD arrayDouble

WRTVD arrayDouble
WRTLN
;----------OPERACIONESCONVECTORFLOAT-----------


READVF arrayFloat
PUSHVF arrayFloat
POPVF arrayFloat

WRTVF arrayFloat
WRTLN
;----------OPERACIONESCONVECTORCHAR-----------


READVC arrayChar
PUSHVC arrayChar
POPVC arrayChar

WRTVC arrayChar
WRTLN
;----------OPERACIONESCONVECTORSTRING-----------


READVS arrayString
PUSHVS arrayString
POPVS arrayString

WRTVS arrayString
WRTLN


;----------OPERACIONESCONCOMPARESYJUMPS-----------


ETQREADS: READI primerNumero
READI segundoNumero

PUSHI primerNumero
PUSHI segundoNumero

CMPEQ
JMPT ETQTERMINAR

PUSHI primerNumero
PUSHI segundoNumero

CMPNE
JMPF ETQTERMINAR

PUSHI primerNumero
PUSHI segundoNumero

CMPLT
JMPT ETQTERMINAR

PUSHI primerNumero
PUSHI segundoNumero

CMPLE
JMPT ETQTERMINAR

PUSHI primerNumero
PUSHI segundoNumero

CMPGT
JMPT ETQTERMINAR

PUSHI primerNumero
PUSHI segundoNumero

CMPGE
JMPT ETQTERMINAR

ETQTERMINAR: HALT