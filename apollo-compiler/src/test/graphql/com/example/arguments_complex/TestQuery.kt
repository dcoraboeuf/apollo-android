// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.arguments_complex

import com.apollographql.apollo.api.Input
import com.apollographql.apollo.api.InputFieldMarshaller
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ResponseFieldMapper
import com.apollographql.apollo.api.ResponseFieldMarshaller
import com.apollographql.apollo.api.ResponseReader
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.internal.QueryDocumentMinifier
import com.example.arguments_complex.type.Episode
import java.io.IOException
import kotlin.Any
import kotlin.Array
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Map
import kotlin.jvm.Throws
import kotlin.jvm.Transient
import okio.BufferedSource

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
data class TestQuery(
  val episode: Input<Episode>,
  val stars: Int,
  val greenValue: Double
) : Query<TestQuery.Data, TestQuery.Data, Operation.Variables> {
  @Transient
  private val variables: Operation.Variables = object : Operation.Variables() {
    override fun valueMap(): Map<String, Any?> = mutableMapOf<String, Any?>().apply {
      if (episode.defined) this["episode"] = episode.value
      this["stars"] = stars
      this["greenValue"] = greenValue
    }

    override fun marshaller(): InputFieldMarshaller = InputFieldMarshaller { writer ->
      if (episode.defined) writer.writeString("episode", episode.value?.rawValue)
      writer.writeInt("stars", stars)
      writer.writeDouble("greenValue", greenValue)
    }
  }

  override fun operationId(): String = OPERATION_ID
  override fun queryDocument(): String = QUERY_DOCUMENT
  override fun wrapData(data: Data?): Data? = data
  override fun variables(): Operation.Variables = variables
  override fun name(): OperationName = OPERATION_NAME
  override fun responseFieldMapper(): ResponseFieldMapper<Data> = ResponseFieldMapper {
    Data(it)
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters)

  data class HeroWithReview(
    val __typename: String,
    /**
     * What this human calls themselves
     */
    val name: String,
    /**
     * Height in the preferred unit, default is meters
     */
    val height: Double?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
      it.writeString(RESPONSE_FIELDS[0], __typename)
      it.writeString(RESPONSE_FIELDS[1], name)
      it.writeDouble(RESPONSE_FIELDS[2], height)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, false, null),
          ResponseField.forDouble("height", "height", mapOf<String, Any>(
            "unit" to "FOOT"), true, null)
          )

      operator fun invoke(reader: ResponseReader): HeroWithReview {
        val __typename = reader.readString(RESPONSE_FIELDS[0])
        val name = reader.readString(RESPONSE_FIELDS[1])
        val height = reader.readDouble(RESPONSE_FIELDS[2])
        return HeroWithReview(
          __typename = __typename,
          name = name,
          height = height
        )
      }
    }
  }

  data class Data(
    val heroWithReview: HeroWithReview?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
      it.writeObject(RESPONSE_FIELDS[0], heroWithReview?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forObject("heroWithReview", "heroWithReview", mapOf<String, Any>(
            "episode" to mapOf<String, Any>(
              "kind" to "Variable",
              "variableName" to "episode"),
            "review" to mapOf<String, Any>(
              "stars" to mapOf<String, Any>(
                "kind" to "Variable",
                "variableName" to "stars"),
              "favoriteColor" to mapOf<String, Any>(
                "red" to "0",
                "green" to mapOf<String, Any>(
                  "kind" to "Variable",
                  "variableName" to "greenValue"),
                "blue" to "0.0"),
              "listOfStringNonOptional" to "[]"),
            "listOfInts" to
              "[{kind=Variable, variableName=stars}, {kind=Variable, variableName=stars}]"), true,
              null)
          )

      operator fun invoke(reader: ResponseReader): Data {
        val heroWithReview = reader.readObject<HeroWithReview>(RESPONSE_FIELDS[0]) { reader ->
          HeroWithReview(reader)
        }

        return Data(
          heroWithReview = heroWithReview
        )
      }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "ea0219363b8af60b029b30af551861cbae30648978be2060651eacc0e34a79d0"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery(${'$'}episode: Episode, ${'$'}stars: Int!, ${'$'}greenValue: Float!) {
          |  heroWithReview(episode: ${'$'}episode, review: {stars: ${'$'}stars, favoriteColor: {red: 0, green: ${'$'}greenValue, blue: 0}, listOfStringNonOptional: []}, listOfInts: [${'$'}stars, ${'$'}stars]) {
          |    __typename
          |    name
          |    height(unit: FOOT)
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = OperationName { "TestQuery" }
  }
}
