/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.opensearch.dataprepper.model.source;

import org.opensearch.dataprepper.model.source.coordinator.SourcePartitionStatus;
import org.opensearch.dataprepper.model.source.coordinator.SourcePartitionStoreItem;

import java.util.Optional;

/**
 * The interface to be implemented when creating a new store plugin for a {@link org.opensearch.dataprepper.model.source.coordinator.SourceCoordinator} to use
 * to coordinate and save progress for processing source partitions
 * @since 2.2
 */
public interface SourceCoordinationStore {

    Optional<SourcePartitionStoreItem> getSourcePartitionItem(final String partitionKey);

    boolean tryCreatePartitionItem(final String partitionKey,
                                   final SourcePartitionStatus sourcePartitionStatus,
                                   final Long closedCount,
                                   final String partitionProgressState);
}
