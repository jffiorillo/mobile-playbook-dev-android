package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem system, int orientation) {
        int offset;
        int chainsSize;
        ChainHead[] chainsArray;
        if (orientation == 0) {
            offset = 0;
            chainsSize = constraintWidgetContainer.mHorizontalChainsSize;
            chainsArray = constraintWidgetContainer.mHorizontalChainsArray;
        } else {
            offset = 2;
            chainsSize = constraintWidgetContainer.mVerticalChainsSize;
            chainsArray = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i = 0; i < chainsSize; i++) {
            ChainHead first = chainsArray[i];
            first.define();
            if (constraintWidgetContainer.optimizeFor(4)) {
                if (!Optimizer.applyChainOptimized(constraintWidgetContainer, system, orientation, offset, first)) {
                    applyChainConstraints(constraintWidgetContainer, system, orientation, offset, first);
                }
            } else {
                applyChainConstraints(constraintWidgetContainer, system, orientation, offset, first);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:190:0x0648  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0654  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x065c  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0674  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0680  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0670  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0659  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x064d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void applyChainConstraints(android.support.constraint.solver.widgets.ConstraintWidgetContainer r44, android.support.constraint.solver.LinearSystem r45, int r46, int r47, android.support.constraint.solver.widgets.ChainHead r48) {
        /*
            Method dump skipped, instructions count: 1718
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.Chain.applyChainConstraints(android.support.constraint.solver.widgets.ConstraintWidgetContainer, android.support.constraint.solver.LinearSystem, int, int, android.support.constraint.solver.widgets.ChainHead):void");
    }
}
