package sml.instructions

import sml.Instruction
import sml.Machine

class DivInstruction(label: String, val result: Int, val op1: Int, val op2: Int): Instruction(label, "div") {
    override fun execute(m: Machine) {
        val value1 = m.registers.getRegister(op1)
        val value2 = m.registers.getRegister(op2)
        val div = try {
            value1 / value2
        } catch (e: ArithmeticException) {
            throw e
        }
        m.registers.setRegister(result, div)
    }

    override fun toString(): String {
        return super.toString() + " " + op1 + " / " + op2 + " to " + result
    }
}