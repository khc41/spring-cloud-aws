package io.awspring.cloud.sqs.operations;

import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.batchmanager.SqsAsyncBatchManager;
import software.amazon.awssdk.services.sqs.model.*;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class BatchingSqsClientAdapter implements SqsAsyncClient {
	private final SqsAsyncBatchManager batchManager;

	public BatchingSqsClientAdapter(SqsAsyncBatchManager batchManager) {
		Assert.notNull(batchManager, "batchManager cannot be null");
		this.batchManager = batchManager;
	}

	@Override
	public String serviceName() {
		return SqsAsyncClient.SERVICE_NAME;
	}

	@Override
	public void close() {
		batchManager.close();
	}

	@Override
	public CompletableFuture<SendMessageResponse> sendMessage(SendMessageRequest sendMessageRequest) {
		return batchManager.sendMessage(sendMessageRequest);
	}

	@Override
	public CompletableFuture<SendMessageResponse> sendMessage(Consumer<SendMessageRequest.Builder> sendMessageRequest) {
		return batchManager.sendMessage(sendMessageRequest);
	}

	@Override
	public CompletableFuture<ReceiveMessageResponse> receiveMessage(ReceiveMessageRequest receiveMessageRequest) {
		return batchManager.receiveMessage(receiveMessageRequest);
	}

	@Override
	public CompletableFuture<ReceiveMessageResponse> receiveMessage(Consumer<ReceiveMessageRequest.Builder> receiveMessageRequest) {
		return batchManager.receiveMessage(receiveMessageRequest);
	}

	@Override
	public CompletableFuture<DeleteMessageResponse> deleteMessage(DeleteMessageRequest deleteMessageRequest) {
		return batchManager.deleteMessage(deleteMessageRequest);
	}

	@Override
	public CompletableFuture<DeleteMessageResponse> deleteMessage(Consumer<DeleteMessageRequest.Builder> deleteMessageRequest) {
		return batchManager.deleteMessage(deleteMessageRequest);
	}

	@Override
	public CompletableFuture<ChangeMessageVisibilityResponse> changeMessageVisibility(ChangeMessageVisibilityRequest changeMessageVisibilityRequest) {
		return batchManager.changeMessageVisibility(changeMessageVisibilityRequest);
	}

	@Override
	public CompletableFuture<ChangeMessageVisibilityResponse> changeMessageVisibility(Consumer<ChangeMessageVisibilityRequest.Builder> changeMessageVisibilityRequest) {
		return batchManager.changeMessageVisibility(changeMessageVisibilityRequest);
	}
}
