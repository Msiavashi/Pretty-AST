# Pretty-AST

A plugin for [Scala 2 compiler](https://github.com/scala/scala) to pretty print AST.

## Source code compilation
```bash
  $ cd ./src/com/mohammad
  $ mkdir classes
  $ scalac -d classes ASTPrinter.scala
  $ cp scalac-plugin.xml classes
  $ (cd classes; jar cf ../astprinter.jar .)
```
## Program compilation
```bash
$ scalac -Xplugin:astprinter.jar <app.scala>
```
## Example

Here, the output for a simple program is shown:

__Program__

```scala
object Test {
  def main(args: Array[String]): Unit = {
    println("Hello World!");
  }
}
```

__Output__
```text
Nodes (without duplicate): 

1- PackageDef
2- Ident
3- <empty>
4- List
5- ClassDef
6- Modifiers
7- MODULE
8- Test
9- Template
10- Select
11- scala
12- TypeName
13- "AnyRef"
14- noSelfType
15- DefDef
16- termNames.CONSTRUCTOR
17- TypeTree
18- Block
19- Apply
20- Super
21- This
22- "Test"
23- typeNames.EMPTY
24- Literal
25- Constant
26- TermName
27- "main"
28- ValDef
29- PARAM
30- "args"
31- .setOriginal
32- AppliedTypeTree
33- scala.Array
34- "scala"
35- scala.Predef
36- "String"
37- EmptyTree
38- scala.Unit
39- "println"
40- "HelloWorld!"

Tree representaion: 

PackageDef
|-Ident
| |-<empty>
|-List
| |-ClassDef
| | |-Modifiers
| | | |-MODULE
| | |-Test
| | |-List
| | | |-
| | |-Template
| | | |-List
| | | | |-Select
| | | | | |-Ident
| | | | | | |-scala
| | | | | |-TypeName
| | | | | | |-"AnyRef"
| | | |-noSelfType
| | | |-List
| | | | |-DefDef
| | | | | |-Modifiers
| | | | | | |-
| | | | | |-termNames.CONSTRUCTOR
| | | | | |-List
| | | | | | |-
| | | | | |-List
| | | | | | |-List
| | | | | | | |-
| | | | | |-TypeTree
| | | | | | |-
| | | | | |-Block
| | | | | | |-List
| | | | | | | |-Apply
| | | | | | | | |-Select
| | | | | | | | | |-Super
| | | | | | | | | | |-This
| | | | | | | | | | | |-TypeName
| | | | | | | | | | | | |-"Test"
| | | | | | | | | | |-typeNames.EMPTY
| | | | | | | | | |-termNames.CONSTRUCTOR
| | | | | | | | |-List
| | | | | | | | | |-
| | | | | | |-Literal
| | | | | | | |-Constant
| | | | | | | | |-
| | | | | | | | | |-
| | | | |-DefDef
| | | | | |-Modifiers
| | | | | | |-
| | | | | |-TermName
| | | | | | |-"main"
| | | | | |-List
| | | | | | |-
| | | | | |-List
| | | | | | |-List
| | | | | | | |-ValDef
| | | | | | | | |-Modifiers
| | | | | | | | | |-PARAM
| | | | | | | | |-TermName
| | | | | | | | | |-"args"
| | | | | | | | |-TypeTree
| | | | | | | | | |-.setOriginal
| | | | | | | | | |-AppliedTypeTree
| | | | | | | | | | |-Select
| | | | | | | | | | | |-Ident
| | | | | | | | | | | | |-scala
| | | | | | | | | | | |-scala.Array
| | | | | | | | | | |-List
| | | | | | | | | | | |-TypeTree
| | | | | | | | | | | | |-.setOriginal
| | | | | | | | | | | | |-Select
| | | | | | | | | | | | | |-Select
| | | | | | | | | | | | | | |-This
| | | | | | | | | | | | | | | |-TypeName
| | | | | | | | | | | | | | | | |-"scala"
| | | | | | | | | | | | | | |-scala.Predef
| | | | | | | | | | | | | |-TypeName
| | | | | | | | | | | | | | |-"String"
| | | | | | | | |-EmptyTree
| | | | | |-TypeTree
| | | | | | |-.setOriginal
| | | | | | |-Select
| | | | | | | |-Ident
| | | | | | | | |-scala
| | | | | | | |-scala.Unit
| | | | | |-Apply
| | | | | | |-Select
| | | | | | | |-Select
| | | | | | | | |-This
| | | | | | | | | |-TypeName
| | | | | | | | | | |-"scala"
| | | | | | | | |-scala.Predef
| | | | | | | |-TermName
| | | | | | | | |-"println"
| | | | | | |-List
| | | | | | | |-Literal
| | | | | | | | |-Constant
| | | | | | | | | |-"HelloWorld!"
```
