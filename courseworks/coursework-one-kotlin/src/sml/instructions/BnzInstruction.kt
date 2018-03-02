package sml.instructions

import sml.Instruction
import sml.Machine

class BnzInstruction(label: String, val register:Int, val nextOp: String): Instruction(label, "bnz") {
    override fun execute(m: Machine) {
        if (m.registers.getRegister(register) != 0) {
            val nextIns: Instruction = Instruction.Companion.getNextInstruction(m.prog, nextOp)
            nextIns.execute(m)
        }
    }

    override fun toString(): String {
        return super.toString() + " register is " + register + " op is " + nextOp
    }
}