// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.doris.nereids.trees.expressions.functions.agg;

import org.apache.doris.nereids.trees.expressions.Expression;
import org.apache.doris.nereids.trees.expressions.functions.AlwaysNotNullable;
import org.apache.doris.nereids.trees.expressions.functions.BitmapIntersectFunction;
import org.apache.doris.nereids.trees.expressions.visitor.ExpressionVisitor;
import org.apache.doris.nereids.util.ExpressionUtils;

import com.google.common.base.Preconditions;

import java.util.List;

/**
 * AggregateFunction 'orthogonal_bitmap_intersect'. This class is generated by GenerateFunction.
 */
public class OrthogonalBitmapIntersect extends AggregateFunction
        implements AlwaysNotNullable, OrthogonalBitmapFunction, BitmapIntersectFunction {

    /**
     * constructor with 3 or more arguments.
     */
    public OrthogonalBitmapIntersect(Expression arg0, Expression arg1, Expression arg2, Expression... varArgs) {
        super("orthogonal_bitmap_intersect", ExpressionUtils.mergeArguments(arg0, arg1, arg2, varArgs));
    }

    /**
     * constructor with 3 or more arguments.
     */
    public OrthogonalBitmapIntersect(boolean distinct, Expression arg0, Expression arg1,
            Expression arg2, Expression... varArgs) {
        super("orthogonal_bitmap_intersect", distinct,
                ExpressionUtils.mergeArguments(arg0, arg1, arg2, varArgs));
    }

    /**
     * withDistinctAndChildren.
     */
    @Override
    public OrthogonalBitmapIntersect withDistinctAndChildren(boolean distinct, List<Expression> children) {
        Preconditions.checkArgument(children.size() >= 3);
        return new OrthogonalBitmapIntersect(distinct, children.get(0), children.get(1), children.get(2),
                children.subList(3, children.size()).toArray(new Expression[0]));
    }

    @Override
    public <R, C> R accept(ExpressionVisitor<R, C> visitor, C context) {
        return visitor.visitOrthogonalBitmapIntersect(this, context);
    }
}
