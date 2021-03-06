/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 CodeRevisited.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.coderevisited.trees.bst;

import com.coderevisited.trees.binarytree.BinaryTree;
import com.coderevisited.trees.binarytree.BinaryTreeNode;

public class KthLargestElement
{
    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildBST();
        for (int i = 1; i < 10; i++) {
            BinaryTreeNode kthSmallest = findKthLargestElement(root, new int[]{i});
            System.out.println(i + "th Largest " + kthSmallest.getValue());
        }
    }

    private static BinaryTreeNode findKthLargestElement(BinaryTreeNode node, int[] k)
    {
        if (node == null)
            return null;
        BinaryTreeNode result = findKthLargestElement(node.getRight(), k);
        if (result != null)
            return result;
        k[0]--;
        if (k[0] == 0)
            return node;

        return findKthLargestElement(node.getLeft(), k);

    }
}
