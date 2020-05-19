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
