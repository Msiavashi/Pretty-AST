package com.mohammad 
import scala.tools.nsc
import nsc.Global
import nsc.ast.Printers
import nsc.Phase
import nsc.plugins.Plugin
import nsc.plugins.PluginComponent

class ASTPrinter(val global: Global) extends Plugin{
  import global._

  val name = "ast-pretty-printer"
  val description = "prints the AST"
  val components = List[PluginComponent](Component)

  private object Component extends PluginComponent {
    val global: ASTPrinter.this.global.type = ASTPrinter.this.global
    val runsAfter = List[String]("refchecks")
    val phaseName = ASTPrinter.this.name
    def newPhase(_prev: Phase) = new ASTPrettyPrinter(_prev)
    class ASTPrettyPrinter(prev: Phase) extends StdPhase(prev) {
      override def name = ASTPrinter.this.name

      def apply(unit: CompilationUnit): Unit = {
          var trees = Set[Tree]()
          var ast: String = ""
          trees ++= global.currentRun.units.map(_.body)
          for(t <- trees){
            ast = ast + showRaw(t)
          }
          getASTNodes(ast)
          println();
          println("Tree representaion: \n")
          prettyPrint(ast)
      }

      def getASTNodes(input: String) {
        var nodes: Array[String] = Array[String] ()
        var tmpNode: String = ""
        var counter: Int = 1;
        println("Nodes (without duplicate): \n")
        input.foreach {
          case '(' | ')' | ',' => {
            if( (tmpNode != "") && !nodes.contains(tmpNode) ){
              println(counter + "- " + tmpNode)
              counter += 1
              nodes :+= tmpNode
            }
            tmpNode = "";
          }
          case ' ' =>
          case f => tmpNode += f 
        }
      }

      def prettyPrint(input: String) = {
        var level = 0
        var tabSize = 2
        input.foreach {
          case '(' =>
            level += 1
            println()
            print(("|" + " "*(tabSize-1)) * (level-1))
            print("|" + "-"*(tabSize-1))
          case ')' =>
            level -= 1
          case ',' =>
            println()
            print(("|" + " "*(tabSize-1)) * (level-1))
            print("|" + "-"*(tabSize-1))
          case ' ' =>
          case f => print(f)
        }
      }

    }
  }
}