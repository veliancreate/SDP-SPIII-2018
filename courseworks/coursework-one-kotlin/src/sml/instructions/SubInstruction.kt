package sml.instructions

import sml.Instruction
import sml.Machine

class SubInstruction(label: String, val result: Int, val op1: Int, val op2: Int): Instruction(label, "sub") {
    override fun execute(m: Machine) {
        val value1 = m.registers.getRegister(op1)
        val value2 = m.registers.getRegister(op2)
        m.registers.setRegister(result, value1 - value2)
    }

    override fun toString(): String {
        return super.toString() + " " + op1 + " - " + op2 + " to " + result
    }
}