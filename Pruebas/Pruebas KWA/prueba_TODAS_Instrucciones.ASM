DEFI varInt
DEFD varDouble
DEFF varFloat
DEFC varChar
<<<<<<< HEAD
DEFS 10,varString

=======
DEFS varString
>>>>>>> origin/master
DEFVI arrayInt,4
DEFVD arrayDouble,4
DEFVF arrayFloat,4
DEFVC arrayChar,4
<<<<<<< HEAD
DEFVS arrayString,4


DEFI primerNumero
DEFI segundoNumero
;----------OPERACIONESCONINT-----------

=======
DEFVS arrayString,4,8
DEFI primerNumero
DEFI segundoNumero
WRTM 4,Int:
>>>>>>> origin/master
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
<<<<<<< HEAD
;----------OPERACIONESCONDOUBLE-----------

=======
WRTM 7,Double:
>>>>>>> origin/master
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
<<<<<<< HEAD
;----------OPERACIONESCONFLOAT-----------

=======
WRTM 6,Float:
>>>>>>> origin/master
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
<<<<<<< HEAD
;----------OPERACIONESCONCHAR-----------

=======
WRTM 5,Char:
>>>>>>> origin/master
READC varChar
PUSHC varChar
POPC varChar
WRTC varChar
WRTLN
<<<<<<< HEAD

;----------OPERACIONESCONSTRING-----------

=======
WRTM 7,String:
>>>>>>> origin/master
READS varString
PUSHS varString
PUSHS varString
ADD
POPS varString
WRTS varString
WRTLN
<<<<<<< HEAD

;----------OPERACIONESCONINDEX-----------
;PUSHKI 0
;POPINDEX
=======
PUSHKI 0
POPINDEX
>>>>>>> origin/master
PUSHKI 0
POPI varInt
SETINDEX varInt
SETINDEXK 0
<<<<<<< HEAD

;----------OPERACIONESCONVECTORINT-----------


=======
WRTM 10,VectorInt:
>>>>>>> origin/master
READVI arrayInt
PUSHVI arrayInt
POPVI arrayInt
WRTVI arrayInt
WRTLN
<<<<<<< HEAD

;----------OPERACIONESCONVECTORDOUBLE-----------


=======
WRTM 13,VectorDouble:
>>>>>>> origin/master
READVD arrayDouble
PUSHVD arrayDouble
POPVD arrayDouble
WRTVD arrayDouble
WRTLN
<<<<<<< HEAD
;----------OPERACIONESCONVECTORFLOAT-----------


=======
WRTM 12,VectorFloat:
>>>>>>> origin/master
READVF arrayFloat
PUSHVF arrayFloat
POPVF arrayFloat
WRTVF arrayFloat
WRTLN
<<<<<<< HEAD
;----------OPERACIONESCONVECTORCHAR-----------


=======
WRTM 11,VectorChar:
>>>>>>> origin/master
READVC arrayChar
PUSHVC arrayChar
POPVC arrayChar
WRTVC arrayChar
WRTLN
<<<<<<< HEAD
;----------OPERACIONESCONVECTORSTRING-----------


=======
WRTM 13,VectorString:
>>>>>>> origin/master
READVS arrayString
PUSHVS arrayString
POPVS arrayString
WRTVS arrayString
WRTLN
<<<<<<< HEAD


;----------OPERACIONESCONCOMPARESYJUMPS-----------


ETQREADS: READI primerNumero
=======
WRTM 15,ComparesYJumps:
ETQREADS:READI primerNumero
>>>>>>> origin/master
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