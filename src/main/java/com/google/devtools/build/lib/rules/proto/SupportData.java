// Copyright 2015 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.devtools.build.lib.rules.proto;

import com.google.auto.value.AutoValue;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.devtools.build.lib.actions.Artifact;
import com.google.devtools.build.lib.analysis.TransitiveInfoCollection;
import com.google.devtools.build.lib.collect.nestedset.NestedSet;
import com.google.devtools.build.lib.concurrent.ThreadSafety.Immutable;

import javax.annotation.Nullable;

/**
 * A helper class for the *Support classes containing some data from ProtoLibrary.
 */
@AutoValue
@Immutable
public abstract class SupportData {
  public static SupportData create(
      Predicate<TransitiveInfoCollection> nonWeakDepsPredicate,
      ImmutableList<Artifact> protoSources,
      NestedSet<Artifact> transitiveImports,
      Artifact usedDirectDeps,
      boolean hasProtoSources) {
    return new AutoValue_SupportData(
        nonWeakDepsPredicate, protoSources, transitiveImports, usedDirectDeps, hasProtoSources);
  }

  public abstract Predicate<TransitiveInfoCollection> getNonWeakDepsPredicate();

  public abstract ImmutableList<Artifact> getDirectProtoSources();

  public abstract NestedSet<Artifact> getTransitiveImports();

  @Nullable
  public abstract Artifact getUsedDirectDeps();

  public abstract boolean hasProtoSources();

  SupportData() {}
}
