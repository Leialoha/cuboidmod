Stream.of(
Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
Block.makeCuboidShape(2, 1, 2, 14, 15, 14),
Block.makeCuboidShape(1, 15, 1, 15, 16, 15),
Block.makeCuboidShape(0, 1, 13, 3, 2, 16),
Block.makeCuboidShape(13, 1, 13, 16, 2, 16),
Block.makeCuboidShape(0, 1, 0, 3, 2, 3),
Block.makeCuboidShape(13, 1, 0, 16, 2, 3),
Block.makeCuboidShape(0, 3, 15, 1, 13, 16),
Block.makeCuboidShape(0, 14, 13, 3, 15, 16),
Block.makeCuboidShape(0, 2, 14, 2, 3, 16),
Block.makeCuboidShape(0, 13, 14, 2, 14, 16),
Block.makeCuboidShape(14, 2, 14, 16, 3, 16),
Block.makeCuboidShape(14, 2, 0, 16, 3, 2),
Block.makeCuboidShape(0, 2, 0, 2, 3, 2),
Block.makeCuboidShape(0, 14, 0, 3, 15, 3),
Block.makeCuboidShape(0, 13, 0, 2, 14, 2),
Block.makeCuboidShape(0, 3, 0, 1, 13, 1),
Block.makeCuboidShape(13, 14, 0, 16, 15, 3),
Block.makeCuboidShape(14, 13, 0, 16, 14, 2),
Block.makeCuboidShape(13, 14, 13, 16, 15, 16),
Block.makeCuboidShape(14, 13, 14, 16, 14, 16),
Block.makeCuboidShape(15, 3, 15, 16, 13, 16),
Block.makeCuboidShape(15, 3, 0, 16, 13, 1),
Block.makeCuboidShape(1, 3, 12, 2, 13, 13),
Block.makeCuboidShape(1, 3, 3, 2, 13, 4),
Block.makeCuboidShape(3, 1, 1, 13, 15, 2),
Block.makeCuboidShape(3, 1, 14, 13, 15, 15),
Block.makeCuboidShape(1, 3, 4, 2, 4, 12),
Block.makeCuboidShape(1, 12, 4, 2, 13, 12),
Block.makeCuboidShape(14, 1, 3, 15, 15, 13),
Block.makeCuboidShape(0, 15, 2, 1, 16, 14),
Block.makeCuboidShape(15, 15, 2, 16, 16, 14),
Block.makeCuboidShape(2, 15, 15, 14, 16, 16),
Block.makeCuboidShape(2, 15, 0, 14, 16, 1)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});