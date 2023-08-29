package de.tabit.test.alexandria.model;


import java.util.Arrays;
import java.util.Random;

public class Board {

    public final FieldType[] fieldTypes;

    public Board(int boardFieldCount, int bonusRuleCount, int trapRuleCount) {
        this.fieldTypes = new FieldType[boardFieldCount];
        Arrays.fill(this.fieldTypes, FieldType.EMPTY);
        setFieldTypes(FieldType.BONUS, bonusRuleCount);
        setFieldTypes(FieldType.TRAP, trapRuleCount);
    }

    public FieldType getFieldType(int fieldNumber) {
        if (fieldNumber >= fieldTypes.length || fieldNumber < 0) {
            return FieldType.EMPTY;
        }
        return this.fieldTypes[fieldNumber];
    }

    private void setFieldTypes(FieldType fieldType, int fieldTypeCount) {
        Random random = new Random();
        while (fieldTypeCount > 0) {
            int fieldNumber = random.nextInt(fieldTypes.length);
            FieldType currentFieldType = fieldTypes[fieldNumber];
            if (currentFieldType != FieldType.EMPTY) {
                continue;
            }
            fieldTypes[fieldNumber] = fieldType;
            fieldTypeCount--;
        }
    }

}
