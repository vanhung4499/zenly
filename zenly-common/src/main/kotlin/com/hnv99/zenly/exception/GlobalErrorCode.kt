package com.hnv99.zenly.exception

import com.hnv99.zenly.annotation.ExplainError
import com.hnv99.zenly.consntants.*
import com.hnv99.zenly.dto.ErrorReason
import java.util.*

/**
 * This is the place where global exception codes are defined. It includes exceptions related to authentication,
 * global issues, AOP, etc. Domain-specific exception codes should be placed in the internal exception package of the domain.
 */
enum class GlobalErrorCode(val status: Int, val code: String, val reason: String) : BaseErrorCode {
    @ExplainError("An unexpected error has occurred. Please contact the administrator.")
    INTERNAL_SERVER_ERROR(INTERNAL_SERVER, "GLOBAL_500_1", "Server error, please contact the administrator"),

    @ExplainError("Validation error occurred during the validation process.")
    ARGUMENT_NOT_VALID_ERROR(BAD_REQUEST, "GLOBAL_400_1", "Invalid request"),

    @ExplainError("Occurs when the accessToken expires.")
    TOKEN_EXPIRED(UNAUTHORIZED, "AUTH_401_1", "The token has expired."),

    @ExplainError("Occurs when the refreshToken expires.")
    REFRESH_TOKEN_EXPIRED(FORBIDDEN, "AUTH_403_1", "Authentication time has expired. Please request token reissue."),

    @ExplainError("Occurs when the format of the accessToken in the header is incorrect, indicating a potential token forgery.")
    INVALID_TOKEN(
        FORBIDDEN,
        "AUTH_403_2",
        "The format of the token is incorrect. Please request again with the correct format."
    ),

    @ExplainError("Occurs when there is no accessToken in the header.")
    ACCESS_TOKEN_NOT_EXIST(
        UNAUTHORIZED,
        "AUTH_401_2",
        "The token does not exist. Please include a valid token in the header."
    ),

    @ExplainError("Occurs when there is no accessToken in the header.")
    ACCESS_TOKEN_NOT_FOUND(
        FORBIDDEN,
        "AUTH_403_3",
        "The token does not exist. Please include a valid token in the header."
    ),

    @ExplainError("Requests for a non-existent resource. Please retry with a different request.")
    RESOURCE_NOT_FOUND(NOT_FOUND, "GLOBAL_404_1", "The requested resource was not found on the server."),

    @ExplainError("Request timeout.")
    RESOURCE_REQUEST_TIMEOUT(REQUEST_TIMEOUT, "GLOBAL_408_1", "Request timeout"),

    @ExplainError("Occurs when too many requests are made.")
    SERVER_TOO_MANY_REQUESTS(TOO_MANY_REQUESTS, "GLOBAL_429_1", "Too many requests. Please try again later."),

    @ExplainError("Occurs when an invalid lock identifier is used.")
    BAD_LOCK_IDENTIFIER(INTERNAL_SERVER, "GLOBAL_500_2", "Invalid lock identifier."),

    @ExplainError("Occurs when an unsupported file extension is requested.")
    BAD_FILE_EXTENSION(INTERNAL_SERVER, "GLOBAL_500_3", "Invalid file extension."),

    @ExplainError("Occurs when the requested method is not allowed.")
    SERVER_METHOD_NOT_ALLOWED(METHOD_NOT_ALLOWED, "GLOBAL_405_1", "The requested method is not allowed."),

    @ExplainError("Occurs when the server is currently undergoing maintenance or is unavailable due to overload.")
    SERVER_UNAVAILABLE(
        SERVICE_UNAVAILABLE,
        "GLOBAL_503_1",
        "The server is currently undergoing maintenance or is unavailable due to overload. Please try again later."
    ),

    @ExplainError("Occurs when Redis lock is not available.")
    NOT_AVAILABLE_REDISSON_LOCK(
        INTERNAL_SERVER,
        "GLOBAL_500_4",
        "Redis lock is not available. Please contact the administrator."
    ),

    @ExplainError("Occurs when an exception occurs in another server.")
    OTHER_SERVER_BAD_REQUEST(BAD_REQUEST, "OTHER_SERVER_400_1", "Another server sent an invalid request."),

    @ExplainError("Occurs when an authentication exception occurs in another server.")
    OTHER_SERVER_UNAUTHORIZED(UNAUTHORIZED, "OTHER_SERVER_401_1", "Another server sent an unauthorized request."),

    @ExplainError("Occurs when an authentication exception occurs in another server.")
    OTHER_SERVER_FORBIDDEN(FORBIDDEN, "OTHER_SERVER_403_1", "Another server sent a forbidden request."),

    @ExplainError("Occurs when a token-related authentication exception occurs in another server.")
    OTHER_SERVER_EXPIRED_TOKEN(
        UNAUTHORIZED,
        "OTHER_SERVER_403_2",
        "Another server sent an unauthorized request with an expired token."
    ),

    @ExplainError("Occurs when a wrong resource is requested from another server.")
    OTHER_SERVER_NOT_FOUND(NOT_FOUND, "OTHER_SERVER_404_1", "Another server requested an incorrect resource."),

    @ExplainError("Occurs when an unknown server error occurs in another server.")
    OTHER_SERVER_INTERNAL_SERVER_ERROR(
        INTERNAL_SERVER,
        "OTHER_SERVER_500_1",
        "Another server encountered an unknown server error."
    ),

    SECURITY_CONTEXT_NOT_FOUND(INTERNAL_SERVER, "GLOBAL_500_2", "security context not found"),

    @ExplainError("Occurs when a user does not participate in the corresponding promise.")
    USER_NOT_PARTICIPATE(BAD_REQUEST, "GLOBAL_400_2", "The user does not participate in the corresponding promise."),

    @ExplainError("Occurs when userId cannot be converted to Long.")
    USER_ID_NOT_LONG(INTERNAL_SERVER, "GLOBAL_500_5", "Error converting userId to Long."),

    @ExplainError("Occurs when promiseId cannot be converted to Long.")
    PROMISE_ID_NOT_LONG(INTERNAL_SERVER, "GLOBAL_500_6", "Error converting promiseId to Long."),

    @ExplainError("Occurs when userId is not found in the parameters.")
    USER_ID_PARAMETER_NOT_FOUND(BAD_REQUEST, "GLOBAL_400_3", "userId is not found in the parameters."),

    @ExplainError("Occurs when promiseId is not found in the parameters.")
    PROMISE_ID_PARAMETER_NOT_FOUND(BAD_REQUEST, "GLOBAL_400_4", "promiseId is not found in the parameters."),

    ;

    override val errorReason: ErrorReason
        get() {
            return ErrorReason(status, code, reason)
        }

    override val explainError: String
        get() {
            val field = this.javaClass.getField(name)
            val annotation = field.getAnnotation(ExplainError::class.java)
            return if (Objects.nonNull(annotation)) annotation.value else reason
        }
}