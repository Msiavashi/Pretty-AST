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

      class ASTTraverser extends Traverser {
        override def traverse(tree: Tree): Unit = {
          tree match {
            case i: Ident => {
              println("Ident")
            }
            case p: PackageDef => {
              println("PackageDef")
              super.traverse(tree)
            }
            case alt: Alternative => {
              println("Alternative")
              super.traverse(tree)
            }
            case s: Select => {
              println("Select")
              super.traverse(tree)
            }
            case ad: ApplyDynamic => {
              println("ApplyDynamic")
              super.traverse(tree)
            };
            case app: Apply => {
              println("Apply")
              super.traverse(tree)
            }
            case ta: TypeApply => {
              println("TypeApply")
              super.traverse(tree)
            }
            case att: AppliedTypeTree => {
              println("AppliedTypeTree")
              super.traverse(tree)
            }
            case t: Throw => {
              println("Throw")
              super.traverse(tree)
            }
            case b: Bind => {
              println("Bind")
              super.traverse(tree)
            }
            case ld: LabelDef => {
              println("LabelDef")
              super.traverse(tree)
            }
            case f: Function => {
              println("Function")
              super.traverse(tree)
            }
            case tr: Try => {
              println("Try")
              super.traverse(tree)
            }
            case m: Match => {
              println("Match")
              super.traverse(tree)
            }
            case cd: CaseDef => {
              println("CaseDef")
              super.traverse(tree)
            }
            case blk: Block => {
              println("Block")
              super.traverse(tree)
            }
            case an: Annotated => {
              println("Annotated")
              super.traverse(tree)
            }
            case clsd: ClassDef => {
              println("ClassDef")
              super.traverse(tree)
            }
            case md: ModuleDef => {
              println("ModuleDef")
              super.traverse(tree)
            }
            case dd: DefDef => {
              println("DefDef")
              super.traverse(tree)
            }
            case lit: Literal => {
              println("Literal")
              super.traverse(tree)
            }
            case New(tpt) => {
              println("New")
              super.traverse(tree)
            }
            case s: Super => {
              println("Super")
              super.traverse(tree)
            }
            case temp: Template => {
              println("Template")
              super.traverse(tree)
            }
            case th: This => {
              println("This")
              super.traverse(tree)
            }
            case tt: TypeTree => {
              println("TypeTree")
              super.traverse(tree)
            }
            case tpd: Typed => {
              println("Typed")
              super.traverse(tree)
            }
            case as: Assign => {
              println("Assign")
              super.traverse(tree)
            }
            case ctt: CompoundTypeTree => {
              println("CompundTypeTree")
              super.traverse(tree)
            }
            case dt: DefTree => {
              println("DefTree")
              super.traverse(tree)
            }
            case ett: ExistentialTypeTree => {
              println("ExistentialTypeTree")
              super.traverse(tree)
            }
            case ga: GenericApply => {
              println("ExistentialTypeTree")
              super.traverse(tree)
            }
            case i: If => {
              println("If")
              super.traverse(tree)
            }
            // case impldef: ImplDef => {
            //   println("ImplDef")
            //   super.traverse(tree)
            // }
            case imp: Import => {
              println("Import")
              super.traverse(tree)
            }
            // case tpd: Typed  => {
            //   println("Typed")
            //   super.traverse(tree)
            // }
            case ua: UnApply => {
              println("UnApply")
              super.traverse(tree)
            }
            // case vd: ValDef => {
            //   println("ValDef")
            //   super.traverse(tree)
            // }
            // case vdd: ValOrDefDef => {
            //   println("ValOrDefDef")
            //   super.traverse(tree)
            // }
            // case vd: ValDef => {
            //   println("ValDef")
            //   super.traverse(tree)
            // }
            case trt: TermTree => {
              println("TermTree")
              super.traverse(tree)
            }
            case smt: SymTree => {
              println("SymTree")
              super.traverse(tree)
            }
            // case s: Star => {
            //   println("Star")
            //   super.traverse(tree)
            // }
            case stt: SingletonTypeTree => {
              println("SingletonTypeTree")
              super.traverse(tree)
            }
            // case sftt: SelectFromTypeTree => {
            //   println("SelectFromTypeTree")
            //   super.traverse(tree)
            // }
            // case ret: Return => {
            //   println("Return")
            //   super.traverse(tree)
            // }
            // case memd: MemberDef => {
            //   println("MemberDef")
            //   super.traverse(tree)
            // }
            // case md: ModuleDef => {
            //   println("ModuleDef")
            //   super.traverse(tree)
            // }
            case nt: NameTree => {
              println("NamekTree")
              super.traverse(tree)
            }
            // case n: New => {
            //   println("New")
            //   super.traverse(tree)
            // }
            // case rt: RefTree => {
            //   println("RefTree")
            //   super.traverse(tree)
            // }
            case tbt: TypeBoundsTree => {
              println("TypeBoundsTree")
              super.traverse(tree)
            }
            // case td: TypeDef => {
            //   println("TypeDef")
            //   super.traverse(tree)
            // }
            case EmptyTree => {
              println("EmptyTree")
              super.traverse(tree)
            }
          }
        }
      }

      def apply(unit: CompilationUnit): Unit = {
          var trees = Set[Tree]()
          trees ++= global.currentRun.units.map(_.body)
          for(t <- trees){
            println("Node types:\n")
            new ASTTraverser().traverse(t)
            println()
            println("Tree representaion:\n")
            prettyPrint(showRaw(t))
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