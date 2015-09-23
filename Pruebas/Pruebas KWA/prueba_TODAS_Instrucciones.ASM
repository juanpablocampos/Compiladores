DEFI varInt
DEFD varDouble
DEFF varFloat
DEFC varChar
DEFS 5,varString

DEFVI arrayInt,4
DEFVD arrayDouble,4
DEFVF arrayFloat,4
DEFVC arrayChar,4
DEFVS arrayString,4


DEFI primerNumero
DEFI segundoNumero

WRTM 10,Vanlosints
READI varInt

PUSHI varInt
PUSHI varInt
ADD

POPI varInt
WRTI varInt
PUSHI varInt
PUSHKI 2
SUB

POPI varInt
WRTI varInt
PUSHI varInt
PUSHI varInt
MUL

POPI varInt
WRTI varInt
PUSHI varInt
PUSHI varInt
DIV

POPI varInt
WRTI varInt
PUSHI varInt
PUSHI varInt
MOD

POPI varInt
WRTI varInt
WRTLN

WRTM 12,VanlosDouble
READD varDouble

PUSHD varDouble
PUSHD varDouble
ADD

POPD varDouble
WRTD varDouble
PUSHD varDouble
PUSHKD 2
SUB

POPD varDouble
WRTD varDouble
PUSHD varDouble
PUSHD varDouble
MUL

POPD varDouble
WRTD varDouble
PUSHD varDouble
PUSHD varDouble
DIV

POPD varDouble
WRTD varDouble
PUSHD varDouble
PUSHD varDouble
MOD

POPD varDouble
WRTD varDouble
WRTLN

WRTM 11,VanlosFloat
READF varFloat

PUSHF varFloat
PUSHF varFloat
ADD

POPF varFloat
WRTF varFloat
PUSHF varFloat
PUSHKF 2.2
SUB

POPF varFloat
WRTF varFloat
PUSHF varFloat
PUSHF varFloat
MUL

POPF varFloat
WRTF varFloat
PUSHF varFloat
PUSHF varFloat
DIV

POPF varFloat
WRTF varFloat
PUSHF varFloat
PUSHF varFloat
MOD

POPF varFloat
WRTF varFloat
WRTLN

WRTM 11,Vaelchar
READC varChar

PUSHC varChar
POPC varChar

WRTC varChar
WRTLN

WRTM 13,Vaelstring
READS varString

PUSHS varString
PUSHS varString
ADD
POPS varString

WRTS varString
WRTLN

PUSHKI 0
POPINDEX
PUSHKI 0
POPI varInt
SETINDEX varInt
SETINDEXK 0

WRTM 13,VaelvectorInt
READVI arrayInt
PUSHVI arrayInt
POPVI arrayInt

WRTVI arrayInt
WRTLN


WRTM 16,VaelvectorDouble
READVD arrayDouble
PUSHVD arrayDouble
POPVD arrayDouble

WRTVD arrayDouble
WRTLN


WRTM 15,VaelvectorFloat
READVF arrayFloat
PUSHVF arrayFloat
POPVF arrayFloat

WRTVF arrayFloat
WRTLN

WRTM 14,VaelvectorChar
READVC arrayChar
PUSHVC arrayChar
POPVC arrayChar

WRTVC arrayChar
WRTLN

WRTM 16,VaelvectorString
READVS arrayString
PUSHVS arrayString
POPVS arrayString

WRTVS arrayString
WRTLN

WRTM 16,DamePrimerNumero
READI primerNumero
WRTM 17,DameSegundoNumero
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